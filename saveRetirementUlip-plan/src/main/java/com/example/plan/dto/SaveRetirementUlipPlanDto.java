package com.example.plan.dto;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.TCustomer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "savingPremium" })
public class SaveRetirementUlipPlanDto{
	
	@Id
	private Integer savingId;
	
	@NotNull(message = "savingTenureYrs should not be null")
	private Integer savingTenureYrs;


	private Long savingPremium;

	//@NotNull(message = "savingAmt should not be null")
	private Double savingAmt;	

	//@NotNull(message = "savingMaturityYrs should not be null")
	private Integer savingMaturityYrs;

	@NotNull(message = "rate Of Interest should not be null")
	private Double roi;
	
	private String createdBy;	
	private LocalDateTime createdDate;
	
	private String modifiedBy;	
	private LocalDateTime modifiedDate;
	
	@NotNull(message = "active should not be null")
	private Boolean active;	
	
	private TCustomer tCustomer;
	private PlanType planType;
	
}
