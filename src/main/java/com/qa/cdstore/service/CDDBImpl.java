package com.qa.cdstore.service;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Default
public class CDDBImpl implements CDService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

//	@PostConstruct
//	private void init(){
//		CD placebo = new CD("Placebo", "Pure Morning", "Rock");
//		CD foofighters = new CD("Foo Fighters", "Monkey Wrench", "Rock");
//		em.getTransaction().begin();
//		em.persist(placebo);
//		em.persist(foofighters);
//		em.getTransaction().commit();
//	}
	
	@Override
	 	public String getAllCDs() { 
		Query query	= em.createQuery("SELECT c FROM CD c");
		@SuppressWarnings("unchecked")
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
		
		/*@SuppressWarnings("unchecked")
			final List<CD> results = em.createQuery( 
					"select * from CD c order by c.artist").getResultList(); 
			return util.getJSONForObject(results);*/
 	} 
	
	@Override
 	public String getSingleCD(Integer id) { 
		return util.getJSONForObject(em.find(CD.class, id));
	} 
	
	@Override
	 	public String addNewCD(String cdJson) { 
			CD newCD = util.getObjectForJSON(cdJson, CD.class);
			em.persist(newCD);
			return cdJson;
		} 
		
	@Override
	 	public String replaceCD(Integer cdId,String updatedCD) { 
			CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
			CD cd = findCD(new Integer(cdId));
			if(cd != null){
				cd = updateCD;
				em.merge(cd);
			}
			return "{\"message\": \"book sucessfully updated\"}";
		}
	
	@Override
	 	public String deleteCD(Integer cdId) { 
			CD cd = findCD(new Integer(cdId));
			if(cd != null){
				em.remove(cd);
			}
			return "{\"message\": \"book sucessfully removed\"}";
		}

	private CD findCD(Integer cdId){
		return em.find(CD.class, cdId);
	}
}