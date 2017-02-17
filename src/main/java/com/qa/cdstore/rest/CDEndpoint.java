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
	public String getCdsAsJson(){
			return cdService.getAllCd();
	}
	
	@GET
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String getCdFromCdStore(@PathParam("id") Integer id) {
			return cdService.getCdById(id);
			
	}

	@POST
	@Path("/json")
	@Produces({"application/json"})
	public String addNewCd(String cdJson){
			return cdService.addNewCd(cdJson);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String replaceCdFromCdStore(@PathParam("id") Integer id, String cdJson){
			return cdService.replaceCd(id, cdJson);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String deleteCdFromCdStore(@PathParam("id") Integer id){
			return cdService.deleteCd(id);
	}
}
