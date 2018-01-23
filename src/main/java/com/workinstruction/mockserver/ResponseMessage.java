package com.workinstruction.mockserver;

import org.springframework.http.HttpStatus;

public class ResponseMessage {
	String message;
	HttpStatus status;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
