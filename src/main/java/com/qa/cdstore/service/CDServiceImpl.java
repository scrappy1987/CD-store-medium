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
	private Map<Integer, CD> CDMap;
	private int ID;

	@Inject
	private JSONUtil util;

	public CDServiceImpl() {
		this.CDMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		initCDStore();
	}


	@Override
	public String getAllCDs() {
		return util.getJSONForObject(CDMap.values());
	}

	@Override
	public String addNewCD(String CDJson) {
		ID++;
		CD newCD = util.getObjectForJSON(CDJson, CD.class);
		LOGGER.info("In add CD method about to add to map");
		CDMap.put(ID, newCD);
		LOGGER.info("In add CD method CD added to map");
		return CDJson;
	}

	@Override
	public String replaceCD(Integer CD_ID, String updatedCD) {
		CD newCD = util.getObjectForJSON(updatedCD, CD.class);
		CDMap.put(CD_ID, newCD);
		return updatedCD;
	}

	@Override
	public String deleteCD(Integer CD_ID) {
		LOGGER.info("In delete CD method about to remove CD");
		CDMap.remove(CD_ID);
		LOGGER.info("In delete CD method CD removed");
		return "{\"message\": \"CD sucessfully removed\"}";
	}

	private void initCDStore() {
		CD aCD = new CD(1, "Thriller", "MJ");
		CDMap.put(1, aCD);
	}

}
