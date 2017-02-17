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
import com.qa.cdstore.service.CDService;

@Stateless
@Default
public class CDDBImpl implements CDService {
	
		@PersistenceContext(unitName = "primary")
		private EntityManager em;

		@Inject
		private JSONUtil util;

		@Override
		public String getAllCDs() {
			Query query = em.createQuery("SELECT c FROM CD c");
			Collection<CD> cds = (Collection<CD>) query.getResultList();
			return util.getJSONForObject(cds);
		}
		
		@Override
		public String getSingleCD(Integer cdID) {
			CD cd = em.find(CD.class, cdID);
			return util.getJSONForObject(cd);
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
			CD cd = findCD(new Integer(cdID));
			Integer storeID;
			if (cd != null) {
				storeID= cd.getCdID();
				cd = updateCD;
				cd.setCdID(storeID);
				em.merge(cd);
			}
			return "{\"message\": \"CD updated!\"}";
		}

		@Override
		public String deleteCD(Integer cdID) {
			CD cd = findCD(new Integer(cdID));
			if (cd != null) {
				em.remove(cd);
			}
			return "{\"message\": \"CD removed!\"}";
		}

		private CD findCD(Integer id) {
			return em.find(CD.class, id);
		}

	}

