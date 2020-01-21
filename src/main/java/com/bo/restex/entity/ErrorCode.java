package com.bo.restex.entity;

public class ErrorCode implements ReturnEntity {

	private String title;
	private String type;
	private String errorCode;
	private String errorMessage;

	public ErrorCode(ErrorTemplate errorTemplate) {
		this.title = errorTemplate.getTitle();
		this.type = errorTemplate.getType();
		this.errorCode = errorTemplate.getErrorCode();
		this.errorMessage = errorTemplate.getErrorMessage();
	}


	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
