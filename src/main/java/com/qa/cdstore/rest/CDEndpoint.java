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
	private CDService CdService;
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getCdAsJson(){
		return CdService.getAllCD();
	}
	@POST
	@Path("/json")
	@Produces({"application/json"})
	public String addNewCDToMap(String CdJson){
		return CdService.addNewCD(CdJson);
	}
	@PUT
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String replaceCDFromCDStore(@PathParam("Id") Integer Id, String CdJson) {
		return CdService.replaceCD(Id, CdJson);
	}
	@DELETE 
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String deleteCDFromCDStore(@PathParam("id") Integer Id, String CdJson){
		return CdService.deleteCD(Id);
	}
	

}
