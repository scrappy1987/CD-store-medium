package com.qa.cdstore.service;


public interface CDService {

	public String getAllCDs();
	
	public String getSingleCD(Integer cdId);
	
	public String addNewCD(String cdJson);
	
	public String replaceCD(Integer cdId,String cdJson);
	
	public String deleteCD(Integer cdId);
	
	
}