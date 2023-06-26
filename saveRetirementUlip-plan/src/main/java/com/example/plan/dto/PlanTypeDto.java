package com.example.plan.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import com.example.plan.enums.PlanTypeEnum;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PlanTypeDto {

	private Integer planTypeId;
	
	@NotEmpty(message = "Please Enter Unique planCode")
	private int planCode;
	
	@NotEmpty(message = "Please Enter Unique planName")
	private PlanTypeEnum planName;
	
	private String createdBy;
	private LocalDateTime createdDate;
	private String modifiedBy;
	private LocalDateTime modifiedDate;
	private boolean active;
}