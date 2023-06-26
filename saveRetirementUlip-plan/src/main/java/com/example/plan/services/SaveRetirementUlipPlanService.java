package com.example.plan.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.SaveRetirementUlipPlan;

@Service
public interface SaveRetirementUlipPlanService {
	
	public ResponseEntity<SaveRetirementUlipPlan> createPlan(Integer planTypeId,SaveRetirementUlipPlanDto dto);

	//--------------------------
	
	public ResponseEntity<PlanType> createPlanType(PlanType planType) ;
	public ResponseEntity<PlanType> getPlanbyId(@RequestParam Integer planName);
	
}