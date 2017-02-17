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
	
	@PersistenceContext(unitName= "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllCD() {
		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> Cd= (Collection<CD>) query.getResultList();
		return util.getJSONForObject(Cd);
	}

	@Override
	public String addNewCD(String CDJson) {
		CD newCd = util.getObjectForJSON(CDJson, CD.class);
		em.persist(newCd);
		return CDJson;
	}

	@Override
	public String replaceCD(Integer CDId, String updatedCD) {
		CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
		CD Cd= findCD(new Long(CDId));
		if (Cd !=null){
			Cd = updateCD;
			em.merge(Cd);
		}
		
		return "{\"message\": \"book sucessfully updated\"}";
	}

	private CD findCD(Long Id) {
		return em.find(CD.class, Id);
	}

	@Override
	public String deleteCD(Integer CDId) {
		CD Cd = findCD(new Long(CDId));
		if (Cd != null){
			em.remove(Cd);
		}
		return "{\"message\": \"Cd sucessfully removed\"}";
	}

}
