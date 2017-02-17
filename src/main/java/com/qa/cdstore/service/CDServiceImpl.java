package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

public class CDServiceImpl implements CDService {
	
	private static final Logger LOGGER = Logger.getLogger(CDService.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> CDMap;
	private Integer id;

	@Inject
	private JSONUtil util;

	public CDServiceImpl() {
		this.CDMap = new HashMap<Integer, CD>();
		id = INITIAL_COUNT;
		initCD();
	}

	public String getAllCDs() {
		return util.getJSONForObject(CDMap);
	}

	public String addNewCD(String CDJson) {
		id++;
		CD newcd = util.getObjectForJSON(CDJson, CD.class);
		LOGGER.info("In add cd method about to add to map");
		CDMap.put(id, newcd);
		LOGGER.info("In add cd method CD added to map");
		return CDJson;
	}

	public String replaceCD(Integer CDid, String updatedCD) {
		CD newCD = util.getObjectForJSON(updatedCD, CD.class);
		CDMap.put(id, newCD);
		return updatedCD;
	}

	public String deleteCD(Integer CDId) {
		LOGGER.info("In delete CD method about to remove book");
		CDMap.remove(CDId);
		LOGGER.info("In delete CD method book removed");
		return "{\"message\": \"CD sucessfully removed\"}";
	}

	private void initCD() {
		CD aCD = new CD(1l,"Without You I'm Nothing", "Pure Morning" , "rock", "Placebo", "19.99");
		CDMap.put(1, aCD);
	}

	





}
