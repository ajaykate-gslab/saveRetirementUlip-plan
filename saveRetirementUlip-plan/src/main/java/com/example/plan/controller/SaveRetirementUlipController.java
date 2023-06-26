package com.example.plan.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.repository.PlanTypeRepository;
import com.example.plan.repository.SaveReturnUlipPlanRepository;
import com.example.plan.services.SaveReturnUlipPlanServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/oneapp/api/v1/lifeinsurance")
public class SaveRetirementUlipController {
	
	@Autowired
	private SaveReturnUlipPlanServiceImpl planService;
	@Autowired
	private SaveReturnUlipPlanRepository planRepo;
	@Autowired
	private PlanTypeMapper mapper;
	
//------------ Plan APIs ----------------------------
	
	@PostMapping("/plan/{planTypeId}")
	public ResponseEntity<SaveRetirementUlipPlan> createPlan(@Valid @PathVariable Integer planTypeId, @RequestBody SaveRetirementUlipPlanDto saveRetirementUlipPlanDto){
		return planService.createPlan(planTypeId,saveRetirementUlipPlanDto);
	}
	
	@GetMapping("/plandetails")
	public ResponseEntity<List<SaveRetirementUlipPlan>> getAllPlanDetailsByCustomerId(@RequestParam Integer customerId) {
		//return new ResponseEntity<List<SaveRetirementUlipPlan>>(planRepo.fetchPlanByCustomerId(customerId),HttpStatus.FOUND);
		return planService.fetchPlanByCustomerId(customerId);
	}
	
//------------- Plan Type APIs -----------------------
	
	@PostMapping("/plantype")
	public ResponseEntity<PlanType> createPlanType(@Valid @RequestBody PlanTypeDto planTypeDto){
		return planService.createPlanType(mapper.planTypeDtoToPlanType(planTypeDto));
	}
	
	@GetMapping("/plantype/{planTypeId}")
	public ResponseEntity<PlanType> getPlanType(@PathVariable int planTypeId){
		return planService.getPlanbyId(planTypeId);
		
	}
	
	
	
}
