package com.bo.restex.connections;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bo.restex.entity.ErrorCode;
import com.bo.restex.entity.ErrorTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	private static final ErrorCode code = new ErrorCode(ErrorTemplate.NOT_FOUND);

	public Response toResponse(NotFoundException exception) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(code)).build();
	}

}