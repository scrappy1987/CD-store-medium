package com.qa.cdstore.service;
import com.qa.cdstore.model.*;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Stateless
@Default


public interface CDService {
	

	String getAllCD(String title);
	
	String addNewCD(String newCD);
	
	


}