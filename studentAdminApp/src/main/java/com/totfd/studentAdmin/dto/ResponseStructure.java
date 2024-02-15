package com.totfd.studentAdmin.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private int code;
	private String message;
	private T data;
	
}
