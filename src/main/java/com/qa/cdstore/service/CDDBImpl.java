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
	public String getOneCD(Integer cdId) {
		CD cd = findCD(new Long(cdId));
		if (cd != null){
			return (cd.getArtist() + " "  +cd.getGenre() + " " + cd.getSong());
		}
		return "{\"message\": \"cd retrived\"}";
	}
	
	@Override
	public String addNewCD(String cdJson) {
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		em.persist(newCD);
		return cdJson;
	}

	@Override
	public String replaceCD(Integer cdId, String updateCD) {
		CD updatedCD = util.getObjectForJSON(updateCD, CD.class);
		CD cd = findCD(new Long(cdId));
			if (cd != null){
				cd = updatedCD;
				em.merge(cd);
			}
		return "{\"message\": \"cd updated\"}";
	}

	private CD findCD(Long id) {
		return em.find(CD.class, id);
	}

	@Override
	public String deleteCD(Integer cdId) {
		CD cd = findCD(new Long(cdId));
		if (cd != null){
			em.remove(cd);
		}
		return "{\"message\": \"cd removed\"}";
	}


}
