package com.bo.restex.connections;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bo.restex.entity.Endpoints;

@Path("/")
public class EndpointList {
	private ArrayList<Endpoints> endpoints = new ArrayList<>(Arrays.asList(Endpoints.values()));

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEndpoints() {

		ArrayList<String> result = new ArrayList<String>();

		for (Endpoints endpoint : endpoints) {
			result.add(endpoint.getEndpoint());
		}

		return Response.ok().entity(result).build();
	}

}
