package com.totfd.studentAdmin.exception;

public class NoStudentFoundWithThisNameExcetion extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "No Student Found";
	}
}
