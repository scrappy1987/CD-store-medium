package com.qa.cdstore.service;

public interface CDService {

	String getAllCd ();
	
	String getCdById (Integer cdID);
	
	String addNewCd(String cdJson);
	
	String replaceCd(Integer cdId, String updatedCd);
	
	String deleteCd(Integer cdId);
	
}