package com.project.doctorappointmentsystem.exception;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorInfo {

	private Date timestamp;
	private String message;
	private String details;
	private int status;

	public ErrorInfo(Date timestamp, String message, String details, int code) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.status = code;
	}

}