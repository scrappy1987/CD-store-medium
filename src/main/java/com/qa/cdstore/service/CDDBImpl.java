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

	
	
	@Override
	public String getAllCDs() {

		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);

	}

	@Override
	public String addNewCD(String CDJson) {

		CD newCD = util.getObjectForJSON(CDJson, CD.class);
		em.persist(newCD);
		return CDJson;

	}

	@Override
	public String replaceCD(Integer CDId, String updatedCD) {
		
		CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
		CD cd = findCD(new Long(CDId));
		if(cd != null){
			cd = updateCD;
			em.merge(cd);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
				
	}

	private CD findCD(Long id) {
		return em.find(CD.class, id);
	}

	@Override
	public String deleteCD(Integer CDId) {
		CD cd = findCD(new Long(CDId));
		if(cd != null){
			em.remove(cd);
		}
		return "{\"message\": \"cd sucessfully deleted\"}";
	
	}
	
	
	@Override
	public String seeIfCdExists(Integer CDId){
		try{
		CD cd = findCD(new Long(CDId));
		}
		catch (Exception e){
			return "{\"message\": \"cd was not found\"}";
		}
		return "{\"message\": \"cd sucessfully found\"}";
	}
	
	
	@Override
	public String returnCdArtist(Integer CDId){
		Query query = em.createQuery("Select Artist from CD where id = CDId");
		return util.getJSONForObject(query);
	}
	
}




























