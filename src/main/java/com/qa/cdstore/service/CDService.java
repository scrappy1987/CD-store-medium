package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@ApplicationScoped
public interface CDService {
	
	public String deleteCD(Integer CDId);
	public String addNewCD(String CDJson);
	public String replaceCD(Integer CDid, String updatedCD);
	public String getAllCDs();
}
