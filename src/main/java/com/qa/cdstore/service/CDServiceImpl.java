package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.util.JSONUtil;
import com.qa.cdstore.model.CD;


@ApplicationScoped
@Alternative
public class CDServiceImpl implements CDService {

	private static final Logger LOGGER = Logger.getLogger(CDServiceImpl.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> cdMap;
	private int ID;

	@Inject
	private JSONUtil util;
	
	public CDServiceImpl(){
		this.cdMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		populateCDStore();
	}
	
	private void populateCDStore() {
		CD cd1 = new CD("Placebo", "Pure Morning", "Rock");
		CD cd2 = new CD("Foo Fighters", "Monkey Wrench", "Rock");
		cdMap.put(1, cd1);
		cdMap.put(2, cd2);
	}

	@Override
	public String getAllCDs() {
		return util.getJSONForObject(cdMap.values());
	}

	@Override
	public String getOneCD(Integer cdId) {
		return util.getJSONForObject(cdMap.get(cdId));
	}

	@Override
	public String addNewCD( String cdJson) {
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		LOGGER.info("in method to add new cd");
		cdMap.put(ID, newCD);
		LOGGER.info("cd added correctly");
		return cdJson;
	}

	@Override
	public String replaceCD(Integer cdId, String updateCD) {
		CD newCD = util.getObjectForJSON(updateCD, CD.class);
		cdMap.put(cdId, newCD);
		return updateCD;
	}

	@Override
	public String deleteCD(Integer cdId) {
		LOGGER.info("in method to delete cd by id");
		cdMap.remove(cdId);
		LOGGER.info("cd removed correctly");
		return null;
	}

}
