package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cdstore.service.CDService;


@Path("/cdstore")
public class CDEndpoint {

	@Inject
	private CDService cdService;
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getCDAsJson(){
		return cdService.getAllCDs();
	}
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getOneCDAsJson(Integer id){
		return cdService.getOneCD(id);
	}
	
	@POST
	@Path("/json")
	@Produces({"application/json"})
	public String addCDToMap(String cdJson){
		return cdService.addNewCD(cdJson);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String replaceCDFromCDstore(@PathParam("id") Integer id, String cdJson){
		return cdService.replaceCD(id, cdJson);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String deleteCDFromCDstore(@PathParam("id") Integer id){
		return cdService.deleteCD(id);
	}
	
	
	
}
