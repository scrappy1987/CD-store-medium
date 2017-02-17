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
	private int ID;

	@Inject
	private JSONUtil util;
	
	public CDServiceImpl() {
		this.cdMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		initCdStore();
		
	}
	
	@Override
	public String getAllCd() {
		return util.getJSONForObject(cdMap.values());

	}
	
	@Override
	public String getCdById(Integer cdId) {
		return util.getJSONForObject(cdMap.get(cdId));
		
	}
	
	@Override
	public String addNewCd(String cdJson) {
		ID++;
		CD newCd = util.getObjectForJSON(cdJson, CD.class);
		LOGGER.info("In add cd method about to add to map");
		cdMap.put(ID, newCd);
		LOGGER.info("In add cd method cd added to map");
		return cdJson;
	}
	
	
	@Override
	public String replaceCd(Integer cdId, String updatedCd) {
		CD newCd = util.getObjectForJSON(updatedCd, CD.class);
		cdMap.put(cdId, newCd);
		return updatedCd;
		
	}
	
	@Override
	public String deleteCd(Integer cdId) {
		LOGGER.info("In delete cd method about to remove cd");
		cdMap.remove(cdId);
		LOGGER.info("In delete cd method cd removed");
		return "{\"message\": \"cd sucessfully removed\"}";
	}
	
	private void initCdStore(){
		CD aCd = new CD("Placebo", "Pure Morning", "Rock");
		cdMap.put(1,  aCd);
		
	}
}
