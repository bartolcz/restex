package com.bo.restex.entity;

public enum JsonField {

	Repo_URL("html_url");

	private String param;

	JsonField(String param) {
		this.param = param;
	}

	public String getParam() {
		return this.param;
	}

}
