package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@ApplicationScoped
@Alternative 
public class CDServiceImpl implements CDService {
	
	private static final Logger LOGGER = Logger.getLogger(CDServiceImpl.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> cdMap;
	private int Id;
	
	
	@Inject
	private JSONUtil util;
	
	
	public CDServiceImpl (){
		this.cdMap = new HashMap<Integer, CD>();
		Id =INITIAL_COUNT;
		initCDStore();
		
	}


	private void initCDStore() {
		CD aCD = new CD("jai","mad tunes", "bhangra");
		cdMap.put(1, aCD);
		
	}


	@Override
	public String getAllCD() {
		return util.getJSONForObject(cdMap.values());
	}


	@Override
	public String addNewCD(String CDJson) {
		Id++;
		CD newCD = util.getObjectForJSON(CDJson, CD.class);
		LOGGER.info("In add CD method about to add to map");
		cdMap.put(Id, newCD);
		LOGGER.info("In add CD method CD added to map");
		return CDJson;
	}


	@Override
	public String replaceCD(Integer CDId, String updatedCD) {
		CD newCD = util.getObjectForJSON(updatedCD, CD.class);
		cdMap.put(CDId, newCD);
		return updatedCD;
	}


	@Override
	public String deleteCD(Integer CDId) {
		LOGGER.info("in delete CD method about to remove CD");
		cdMap.remove(CDId);
		LOGGER.info("in delete CD method removed CD");
		return "{\"message\": \"CD sucessfully removed\"}";
	}
}
