package com.example.plan.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.plan.dto.Errors;
import com.example.plan.dto.Message;


@RestControllerAdvice
public class CustomExceptionHandler{
	

	 @Value("${service.name}")
	 private String serviceName;
	 
	 	
	 
	 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	 @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	 public List<Errors> handleDuplicateEntryException(SQLIntegrityConstraintViolationException ex){
		 Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getLocalizedMessage());
		 return  buildCustomError(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
	 
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(HttpMessageNotReadableException.class)
	 public List<Errors> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
		 Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getLocalizedMessage());
		 return  buildCustomError(errorMap, HttpStatus.BAD_REQUEST);
		 
	 }
		/*
		 * @ResponseStatus(HttpStatus.NOT_FOUND)
		 * 
		 * @ExceptionHandler() public List<Errors> handleNotFoundException()
		 */
	 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	 @ExceptionHandler(NoSuchElementException.class)
	 public List<Errors> handleNoSuchElementException(NoSuchElementException ex){
		 Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getLocalizedMessage());
		 return  buildCustomError(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
	 
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public List<Errors> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		 Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getLocalizedMessage());
		 return  buildCustomError(errorMap, HttpStatus.BAD_REQUEST);
		 
	 }
	 
	 
	 
	    private List<Errors> buildCustomError(Map<String, String> errorMap,HttpStatus status){
	        Errors errors = Errors.builder()
	                .source(serviceName.translateEscapes())
	                .errorCode(1200)
	                .statusCode(status.value())
	                .status(status.name())
	                .message(errorMap.entrySet().stream().map(entry-> 
	                Message.builder().field(entry.getKey())
	                .message(entry.getValue()).build()).collect(Collectors.toList()))
	                .build();
	        return List.of(errors);
	    }
	    
	    
	    
	    
	 
	 
	 //--------
	/*
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("Please Enter valid input", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidPlanTypeException.class)
	public ResponseEntity handleInvalidPlanTypeException(InvalidPlanTypeException ex) {
		return new ResponseEntity("Please enter PlanType only [RETIREMENT, SAVING, TERM, ULIP, CHILD]",HttpStatus.BAD_REQUEST);
	}
	 /*
	//---

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public List<Errors> handleInvalidArgument(MethodArgumentNotValidException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error -> {
	            errorMap.put(error.getField(), error.getDefaultMessage());
	        });
	       return buildCustomError(errorMap,HttpStatus.BAD_REQUEST);
	    }

	    private List<Errors> buildCustomError(Map<String, String> errorMap,HttpStatus status){
	        Errors errors = Errors.builder()
	                .source(serviceName.translateEscapes())
	                .errorCode(1000)
	                .statusCode(status.value())
	                .status(status.name())
	                .message(errorMap.entrySet().stream().map(entry-> 
	                Message.builder().field(entry.getKey()).message(entry.getValue()).build()).collect(Collectors.toList()))
	                .build();
	        return List.of(errors);
	    }

	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(Exception.class)
	    public List<Errors> handleBusinessException(Exception ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getLocalizedMessage());
	        return buildCustomError(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    */
	   
} 
