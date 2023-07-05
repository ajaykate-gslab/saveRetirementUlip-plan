package com.example.plan.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.plan.dto.PlanResponse;
import com.example.plan.dto.SaveRetirementUlipPlanDto;

@Service
public interface SaveRetirementUlipPlanService {
	
	public ResponseEntity<PlanResponse> createPlan(Integer planTypeId,SaveRetirementUlipPlanDto dto);

	
}