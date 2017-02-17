package com.qa.cdstore.service;

public interface CDService {

	String getAllCDs();

	String addNewCD(String cdJson);

	String replaceCD(Integer cdId, String updatedCD);

	String deleteCD(Integer CDId);

}