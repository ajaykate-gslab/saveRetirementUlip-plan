package com.example.plan.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.plan.entity.PlanType;

@Service
public interface PlanTypeService {
	public ResponseEntity<PlanType> createPlanType(PlanType planType) ;
	public ResponseEntity<PlanType> getPlanbyId(@RequestParam Integer planName);
}
