package com.bo.restex.connections;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.bo.restex.entity.ErrorCode;
import com.bo.restex.entity.ErrorTemplate;
import com.bo.restex.service.GithubDataService;

@Path("/repos")
public class UserRepos {

	private GithubDataService service;

	public UserRepos() {
		this.service = new GithubDataService();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response nullCatchger(@PathParam("user") String name) {
		return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorCode(ErrorTemplate.BAD_REQUEST_UNKNOWN))
				.build();
	}

	@GET
	@Path("{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveUserRepos(@PathParam("user") String name) {

		if (StringUtils.isBlank(name)) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorCode(ErrorTemplate.BAD_REQUEST_UNKNOWN))
					.build();
		}
		return service.getData(name);

	}

}
