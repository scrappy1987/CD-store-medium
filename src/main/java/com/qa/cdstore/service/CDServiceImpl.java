package com.qa.cdstore.service;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;

import com.qa.cdstore.model.CD;


@ApplicationScoped
@Alternative


public class CDServiceImpl implements CDService {

	private Map<Integer, CD>cdMap;

	@Override
	public String getAllCD(String title) {
		
		return null;
	}

	@Override
	public String addNewCD(String newCD) {
		// TODO Auto-generated method stub
		return null;
	}
}
