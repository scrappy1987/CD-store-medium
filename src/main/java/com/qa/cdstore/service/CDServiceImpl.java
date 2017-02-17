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
			initCDStore();
		}

		@Override
		public String getAllCDs() {
			return util.getJSONForObject(cdMap.values());
		}
		
		@Override
		public String getSingleCD(Integer cdID) {
			return util.getJSONForObject(cdMap.get(cdID));
		}

		@Override
		public String addNewCD(String cdJson) {
			ID++;
			CD newCD = util.getObjectForJSON(cdJson, CD.class);
			LOGGER.info("In add cd method, about to add to map");
			cdMap.put(ID, newCD);
			LOGGER.info("In add cd method, cd added to map!");
			return cdJson;
		}

		@Override
		public String replaceCD(Integer cdID, String updatedCD) {
			CD newCD = util.getObjectForJSON(updatedCD, CD.class);
			cdMap.put(cdID, newCD);
			return updatedCD;
		}

		@Override
		public String deleteCD(Integer cdID) {
			LOGGER.info("In delete cd method, about to remove cd");
			cdMap.remove(cdID);
			LOGGER.info("In delete cd method, cd removed!");
			return "{\"message\": \"CD removed!\"}";
		}

		private void initCDStore() {
			CD pureMorning = new CD(0001, "Placebo", "PureMorning", "Rock");
			cdMap.put(1, pureMorning);
			CD monkeyWrench = new CD(0002, "Foo Fighters", "Monkey Wrench", "Rock");
			cdMap.put(2, monkeyWrench);
		}

}


