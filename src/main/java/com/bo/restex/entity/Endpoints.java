package com.bo.restex.entity;

public enum Endpoints {

	ROOT("GET http://localhost:8080/restex/ "), REPOS("GET http://localhost:8080/repos/{user} ");

	private String endpoint;

	Endpoints(String path) {
		this.endpoint = path;
	}

	public String getEndpoint() {
		return endpoint;
	}

}
