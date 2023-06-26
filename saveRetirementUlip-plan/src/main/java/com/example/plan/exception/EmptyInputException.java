package com.example.plan.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmptyInputException extends RuntimeException {
	/*
	 * private int status; private int errorcode; private String source; private
	 * String message;
	 */
	private static final long serialVersionUID =1L;
	private String errorCode;
	private String errorMessage;

	

}
