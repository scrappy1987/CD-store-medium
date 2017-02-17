package com.qa.cdstore.service;

public interface CDService {
	String getAllCD();
	String addNewCD(String CDJson);
	String replaceCD(Integer CDId, String updatedCD);
	String deleteCD(Integer CDId);

}