package com.qa.cdstore.service;

public interface CDService {
	
	String getAllCDs();
	
	String addNewCD(String cdJson);
	
	String replaceCD(Integer cdID, String updatedCD);
	
	String deleteCD(Integer bookId);

}