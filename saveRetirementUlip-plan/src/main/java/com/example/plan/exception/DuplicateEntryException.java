package com.example.plan.exception;

import java.util.List;

import com.example.plan.dto.Errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DuplicateEntryException extends RuntimeException{

	private static final long serialVersionUID =1L;
	List<Errors> errors;
	
}
