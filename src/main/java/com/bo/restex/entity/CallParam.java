package com.bo.restex.entity;

public enum CallParam {

	REPO_OWNER("/repos?type=owner");

	private String param;

	CallParam(String param) {
		this.param = param;
	}

	public String getParam() {
		return this.param;
	}

}
