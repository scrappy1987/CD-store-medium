package com.qa.cdstore.service;

public interface CDService {
	
	String getAllCDs();
	String addNewCD(String CDJson);
	String replaceCD(Integer CD_ID, String updatedCD);
	String deleteCD(Integer CD_ID);

}