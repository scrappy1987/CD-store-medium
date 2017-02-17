package com.qa.cdstore.service;

public interface CDService {
	
	String getAllCDs();
	
	String addNewCD(String CDJson); 
	
	String replaceCD(Integer CDId, String updateCD);
	
	String deleteCD(Integer CDId);	
	
	String seeIfCdExists(Integer CDId);
	
	String returnCdArtist(Integer CDId);
}