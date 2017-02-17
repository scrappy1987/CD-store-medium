package com.qa.cdstore.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.*;
import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Default
public class CDDBImpl implements CDService {

	// ArrayList<CD>CDarray= new ArrayList();

	@Inject
	private JSONUtil JSONUtil;

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String getAllCD(String cd_title) {
		Query query = em.createQuery("SELECT cd_title FROM CD");
		return JSONUtil.getJSONForObject(query);
	}

	@Override
	public String addNewCD(String newCD) {
		CD cd = JSONUtil.getObjectForJSON(newCD, CD.class);
		em.persist(cd);

		return newCD;

	}

}
