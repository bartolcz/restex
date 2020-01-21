package com.bo.restex.entity;

public enum RepoEndpoint {

	ALL_USER_REPOS("https://api.github.com/users/");

	private String url;

	RepoEndpoint(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

}
