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
	
	@PersistenceContext( unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllCd() {
		Query query = em.createQuery("SELECT e FROM Cd e");
		Collection<CD> cd = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cd);
		
	}
	
	@Override
	public String getCdById(Integer cdId) {
		CD cd = findCD(new Integer(cdId));
		return util.getJSONForObject(cd);
			
	}
	
	@Override
	public String addNewCd(String cdJson){
		CD newCd = util.getObjectForJSON(cdJson, CD.class);
		em.persist(newCd);
		return cdJson;
		
	}
	
	@Override
	public String replaceCd(Integer cdId, String updatedCd) {
		CD updateCd = util.getObjectForJSON(updatedCd, CD.class);
		CD cd = findCD(new Integer(cdId));
		if (cd != null) {
			cd = updateCd;
			em.merge(cd);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
	}
	
	@Override
	public String deleteCd(Integer cdId) {
		CD cd = findCD(new Integer(cdId));
		if (cd !=null) {
			em.remove(cd);
		}
		return "{\"message\": \"cd sucessfully removed\"}";
	}
	
	private CD findCD(int id) {
		return em.find(CD.class, id);
	}
	

	
}
