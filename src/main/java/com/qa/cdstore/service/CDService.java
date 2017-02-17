package com.qa.cdstore.service;

public interface CDService {
	String getAllCDs();
	String addNewCD(String cdJson);
	String replaceCD(Integer cdId, String updateCD);
	String deleteCD(Integer cdId);
	String getOneCD(Integer cdId);
}