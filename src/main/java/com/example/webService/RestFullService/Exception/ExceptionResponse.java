package com.example.webService.RestFullService.Exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStamp;
	private String errorMessage;
	private String errorDetails;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public ExceptionResponse(Date timeStamp, String errorMessage,
			String errorDetails) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}

}
