package com.example.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String status;
	
	private String title;
	
	private String uri;
	
	private String errorMessage;

}
