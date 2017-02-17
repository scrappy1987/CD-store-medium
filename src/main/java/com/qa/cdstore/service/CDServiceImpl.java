package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

import org.apache.log4j.Logger;

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
	public String getAllCds() {
		return util.getJSONForObject(cdMap.values());

	}

	@Override
	public String addNewCd(String cdJson) {
		ID++;
		CD newCd = util.getObjectForJSON(cdJson, CD.class);
		LOGGER.info("In add cd method add to map");
		cdMap.put(ID, newCd);
		LOGGER.info("add book method added to map");
		return cdJson;
	}

	@Override
	public String replaceCd(Integer cdId, String updatedCd) {
		CD newCd = util.getObjectForJSON(updatedCd, CD.class);
		cdMap.put(cdId, newCd);
		return updatedCd;
	}

	@Override
	public String deleteCd(Integer cdID) {
		LOGGER.info("delete cd method will remove book");
		cdMap.remove(cdID);
		LOGGER.info("delete cd method cd removed");
		return "{\"message\": \"cd successfully removed\"}";

	}

	private void initCdStore() {
		CD aCd = new CD("Pure Morning", "Placebo", "Rock");
		cdMap.put(1, aCd);

	}
}
