package com.example.plan.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.plan.enums.PlanTypeEnum;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanTypeDto {

	private Integer planTypeId;
	
	private int planCode;
	private PlanTypeEnum planName;
	private String createdBy;
	private LocalDateTime createdDate;
	private String modifiedBy;
	private LocalDateTime modifiedDate;
	private boolean active;
}