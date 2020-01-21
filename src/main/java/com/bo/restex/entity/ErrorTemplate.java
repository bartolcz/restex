package com.bo.restex.entity;

public enum ErrorTemplate {

	INTERNAL_SERVER_ERROR("Error", "InternalServerErrorException", "500", "Internal Server Error "),
	NO_CONTENT_EXCEPTION("Error", "NoContentException", "204", "No content exception "),
	BAD_REQUEST_UNKNOWN("Error", "BadRequestExcetion", "400", "Bad Request"),
	NOT_FOUND("Error", "NotFoundException", "404", "Not Found");

	private String title;
	private String type;
	private String errorCode;
	private String errorMessage;

	private ErrorTemplate(String title, String type, String errorCode, String errorMessage) {
		this.title = title;
		this.type = type;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

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
