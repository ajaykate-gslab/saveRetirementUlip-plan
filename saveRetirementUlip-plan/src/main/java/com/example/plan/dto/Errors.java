package com.example.plan.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errors {
	 private String status;
	    private Integer statusCode;
	    private Integer errorCode;
	    private String source;
	    private List<Message> message;

	

}
