package com.example.plan.dto;

import java.time.LocalDateTime;

import com.example.plan.enums.PlanTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanResponse {
	
	private Integer savingId;
	private Integer savingTenureYrs;
	private Long savingPremium;
	private Double savingAmt;	
	private Integer savingMaturityYrs;
	private Double roi;
	private String createdBy;	
	private LocalDateTime createdDate;
	private String modifiedBy;	
	private LocalDateTime modifiedDate;
	private Boolean active;	
	private long customerId;
	private Integer planTypeId;
	private PlanTypeEnum planName;
}
