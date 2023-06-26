package com.example.plan.dto;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.validation.annotation.Validated;

import com.example.plan.entity.PlanType;
import com.example.plan.entity.TCustomer;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
@Data
@Validated
public class SaveRetirementUlipPlanDto{
	
	@Id
	private Integer savingId;
	
	@NotNull(message = "nulllllll")
	@NotEmpty(message = "please enter savingTenureYrs ")
	private int savingTenureYrs;
	
	private double savingPremium;
	private double savingAmt;	
	private int savingMaturityYrs;
	private int roi;
	
	
	@NotEmpty(message = "must enter createdBy")
	private String createdBy;	
	private Instant createdDate;
	private String modifiedBy;	
	private Instant modifiedDate;
	private boolean active;	
	
	private TCustomer tCustomer;
	private PlanType planType;
	
}
