package com.example.plan.dto;

import com.example.plan.util.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHandler {

    @JsonProperty("status")
    private Integer status = null;
    @JsonProperty("errorCode")
    private String errorCode = null;
    @JsonProperty("source")
    private String source = Constants.SERVICE_NAME;
    @JsonProperty("message")
    private String message = null;
    @JsonProperty("data")
    private Object data = null;
    @JsonProperty("errors")
    private List<Object> errors = null ;

    public ResponseHandler(){
        super();
//        this.data = new ObjectMapper().createObjectNode();
    }

    public ResponseEntity<Object> generateSuccessResponse(Object data, HttpStatus status,String message){
        this.data = data;
        this.status = status.value();
        this.message = message;
        return new ResponseEntity<>(this,status);
    }
    public ResponseEntity<Object> generateSuccessResponse(HttpStatus status,String message){
        this.status = status.value();
        this.message = message;
        return new ResponseEntity<>(this,status);
    }

    public ResponseEntity<Object> generateFailureResponse(HttpStatus status,String message,Object error){
        this.status = status.value();
        this.message = message;
        this.errors = List.of(error);
        this.errorCode = Constants.SERVICE_ERROR_CODE;
        return new ResponseEntity<>(this,status);
    }
    public ResponseEntity<Object> generateFailureResponse(HttpStatus status,String message,List<Object> errors){
        this.status = status.value();
        this.message = message;
        this.errors = errors;
        this.errorCode = Constants.SERVICE_ERROR_CODE;
        return new ResponseEntity<>(this,status);
    }
}