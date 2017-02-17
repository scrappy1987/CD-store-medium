package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;



@ApplicationScoped
@Alternative
public class CDServiceImpl implements CDService {
	
	private static final Logger LOGGER = Logger.getLogger(CDServiceImpl.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> cdMap;
	private int ID;
	
	@Inject
	private JSONUtil util;
	
	public CDServiceImpl() {
		this.cdMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		initCDStore();
	}
	@Override
	public String getAllCDs() {
		return util.getJSONForObject(cdMap.values());
	}
	@Override
	public String addNewCD(String cdJson) {
		ID++;
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		LOGGER.info("Adding CD to Map");
		cdMap.put(ID, newCD);
		LOGGER.info("Added CD to Map");
		return cdJson;
	}
	@Override
	public String replaceCD(Integer cdID, String updatedCD){
		CD newCD = util.getObjectForJSON(updatedCD, CD.class);
		cdMap.put(cdID, newCD);
		return updatedCD;
	}
	@Override
	public String deleteCD(Integer cdID){
		LOGGER.info("About to delete CD");
		cdMap.remove(cdID);
		LOGGER.info("CD deleted");
		return "{\"CD deleted\"}";
	}

	private void initCDStore() {
		CD cd = new CD("T Swift", "Swift", "Pop");
		cdMap.put(1, cd);
		
	}
	
	
	
}
