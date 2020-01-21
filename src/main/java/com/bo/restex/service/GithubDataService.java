package com.bo.restex.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bo.restex.entity.CallParam;
import com.bo.restex.entity.ErrorCode;
import com.bo.restex.entity.ErrorTemplate;
import com.bo.restex.entity.JsonField;
import com.bo.restex.entity.RepoEndpoint;
import com.bo.restex.entity.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GithubDataService implements JsonDataProvider {

	public Response getData(String param) {
		try {
			String target = getTargetUrl(param);
			Response exchange = retriveDataFromExternalLink(target);

			if (exchange.getStatus() != 200) {
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(new ErrorCode(ErrorTemplate.BAD_REQUEST_UNKNOWN)).build();
			}

			JsonArray jsonArray = extractDataFromResponse(exchange);
			ArrayList<String> repoList = extractData(jsonArray);

			return Response.status(Response.Status.OK).entity(new User(param, repoList)).build();

		} catch (ParseException e) {
			e.printStackTrace();
			return Response.status(Response.Status.NO_CONTENT).entity(new ErrorCode(ErrorTemplate.NO_CONTENT_EXCEPTION))
					.build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(new ErrorCode(ErrorTemplate.INTERNAL_SERVER_ERROR)).build();
		}

	}

	private String getTargetUrl(String param) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(RepoEndpoint.ALL_USER_REPOS.getUrl());
		stringBuilder.append(param);
		stringBuilder.append(CallParam.REPO_OWNER.getParam());

		return stringBuilder.toString();
	}

	private Response retriveDataFromExternalLink(String target) throws Exception {
		Client client = ClientBuilder.newBuilder().connectTimeout(10, TimeUnit.SECONDS).build();
		return client.target(target).request(MediaType.APPLICATION_JSON).get(Response.class);
	}

	private JsonArray extractDataFromResponse(Response exchange) throws ParseException {
		String data = exchange.readEntity(String.class);
		return JsonParser.parseString(data).getAsJsonArray();
	}

	private ArrayList<String> extractData(JsonArray jsonArray) throws Exception {
		ArrayList<String> repoList = new ArrayList<String>();

		for (JsonElement jsonElement : jsonArray) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			String temp = jsonObject.get(JsonField.Repo_URL.getParam()).toString();
			repoList.add(temp.replace("\"", ""));
		}
		return repoList;
	}

}
