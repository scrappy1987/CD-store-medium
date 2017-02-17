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
		private CDService CDService;

		@GET
		@Path("/json")
		@Produces({ "application/json" })
		public String getCDsAsJson() {
			return CDService.getAllCDs();
		}

		@POST
		@Path("/json")
		@Produces({ "application/json" })
		public String addNewCDToMap(String CDJson) {
			return CDService.addNewCD(CDJson);
		}

		@PUT
		@Path("/json/{id}")
		@Produces({ "application/json" })
		public String replaceCDFromCDStore(@PathParam("id") Integer id, String CDJson) {
			return CDService.replaceCD(id, CDJson);
		}

		@DELETE
		@Path("/json/{id}")
		@Produces({ "application/json" })
		public String deleteBookFromCDStore(@PathParam("id") Integer id) {
			return CDService.deleteCD(id);
		}
}
