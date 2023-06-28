package com.example.plan.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.repository.SaveRetirementUlipPlanRepository;
import com.example.plan.services.PlanTypeServiceImpl;
import com.example.plan.services.SaveReturnUlipPlanServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.Validator;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/lifeinsurance")
public class SaveRetirementUlipController {

	@Autowired
	private SaveReturnUlipPlanServiceImpl planService;
	@Autowired
	private PlanTypeServiceImpl planTypeService;
	@Autowired
	private SaveRetirementUlipPlanRepository planRepo;
	@Autowired
	private PlanTypeMapper mapper;
	@Autowired
	private Validator validator;

//------------ Plan APIs ----------------------------

	@PostMapping("/plan/{planTypeId}")
	public ResponseEntity<SaveRetirementUlipPlan> createPlan(@PathVariable Integer planTypeId,@Valid
			@RequestBody SaveRetirementUlipPlanDto saveRetirementUlipPlanDto) {

		return planService.createPlan(planTypeId, saveRetirementUlipPlanDto);
	}

	@GetMapping("/plandetails")
	public ResponseEntity<List<SaveRetirementUlipPlan>> getAllPlanDetailsByCustomerId(
			@RequestParam Integer customerId) {
		// return new
		// ResponseEntity<List<SaveRetirementUlipPlan>>(planRepo.fetchPlanByCustomerId(customerId),HttpStatus.FOUND);
		return planService.fetchPlanByCustomerId(customerId);
	}

	
	

}
