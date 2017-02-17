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
		Collection<CD> CD = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(CD);
	}

	@Override
	public String addNewCD(String CDJson) {
		CD newCD = util.getObjectForJSON(CDJson, CD.class);
		em.persist(newCD);
		return CDJson;
	}

	@Override
	public String replaceCD(Integer CD_ID, String updatedCD) {
		CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
		CD CD = findCD(new Long(CD_ID));
		if (CD != null) {
			CD = updateCD;
			em.merge(CD);
		}
		return "{\"message\": \"CD sucessfully updated\"}";
	}

	@Override
	public String deleteCD(Integer CD_ID) {
		CD CD = findCD(new Long(CD_ID));
		if (CD != null) {
			em.remove(CD);
		}
		return "{\"message\": \"CD sucessfully removed\"}";
	}

	private CD findCD(Long ID) {
		return em.find(CD.class, ID);
	}
}