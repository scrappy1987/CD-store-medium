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


	private static final Logger LOGGER = Logger.getLogger(CDService.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> cdMap;
	private int ID;	
	
	@Inject
	private JSONUtil util;
	
	public CDServiceImpl(){
		this.cdMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		initCDStore();
	}
	
	public String getAllCDs(){
		return util.getJSONForObject(cdMap.values());
	};
	
	public String getSingleCD(Integer cdId){
		return util.getJSONForObject(cdMap.values());
	};
	
	public String addNewCD(String cdJson){
		ID++;
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		LOGGER.info("In add cd method about to add to map");
		cdMap.put(ID, newCD);
		LOGGER.info("In add cd method cd added to map");
		return cdJson;
	};
	
	public String replaceCD(Integer cdId,String updatedCD){
		CD newCD = util.getObjectForJSON(updatedCD, CD.class);
		cdMap.put(cdId, newCD);
		return updatedCD;
	};
	
	public String deleteCD(Integer cdId){
		LOGGER.info("In delete cd method about to delete to map");
		cdMap.remove(cdId);
		LOGGER.info("In delete cd method cd deleted from map");
		return "{\"message\": \"cd sucessfully removed\"}";
	};
	
	private void initCDStore(){
		CD aCD = new CD("Placebo", "Pure Morning", "Rock");
		CD aCD2 = new CD("Foo Fighters", "Monkey Wrench", "Rock");
		cdMap.put(1,aCD);
		cdMap.put(2,aCD2);
	}
}

