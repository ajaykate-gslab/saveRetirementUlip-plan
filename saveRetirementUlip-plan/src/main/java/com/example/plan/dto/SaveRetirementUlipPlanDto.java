package com.example.plan.dto;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.TCustomer;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveRetirementUlipPlanDto{
	
	@Id
	private Integer savingId;
	
	@NotNull(message = "savingTenureYrs should not be null")
	private Integer savingTenureYrs;

	@NotNull(message = "savingPremium should not be null")
	private Double savingPremium;

	@NotNull(message = "savingAmt should not be null")
	private Double savingAmt;	

	@NotNull(message = "savingMaturityYrs should not be null")
	private Integer savingMaturityYrs;

	@NotNull(message = "rate Of Interest should not be null")
	private Integer roi;
	
	private String createdBy;	
	private LocalDateTime createdDate;
	private String modifiedBy;	
	private LocalDateTime modifiedDate;
	
	@NotNull(message = "active should not be null")
	private Boolean active;	
	
	private TCustomer tCustomer;
	private PlanType planType;
	
}
