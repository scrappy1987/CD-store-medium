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
		Collection<CD> CDs = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(CDs);
	}
	@Override
	public String addNewCD(String cdJson) {
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		em.persist(newCD);
		return cdJson;
	}
	@Override
	public String replaceCD(Integer cdID, String updatedCD) {
		CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
		CD cd = findCD(new Long(cdID));
		if (cd != null) {
			cd = updateCD;
			em.merge(cd);
		}
		return "{\"Book Updated\"}";
	}
	@Override
	public String deleteCD(Integer cdID) {
		CD cd = findCD(new Long(cdID));
		if (cd!= null){
			em.remove(cd);
		}
		return "{\"Removed\"}";		
	}
	private CD findCD(Long id) {
		return em.find(CD.class, id);
	}
}
;