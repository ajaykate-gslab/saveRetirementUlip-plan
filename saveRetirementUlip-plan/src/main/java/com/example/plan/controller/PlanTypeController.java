package com.example.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.dto.ResponseHandler;
import com.example.plan.entity.PlanType;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.repository.SaveRetirementUlipPlanRepository;
import com.example.plan.services.PlanTypeService;
import com.example.plan.services.SaveRetirementUlipPlanService;
import com.example.plan.util.Constants;

import jakarta.validation.Valid;
import jakarta.validation.Validator;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/oneabc/adityabirla/api/v1/lifeinsurance")
public class PlanTypeController {


	@Autowired
	private SaveRetirementUlipPlanService planService;
	@Autowired
	private PlanTypeService planTypeService;
	@Autowired
	private SaveRetirementUlipPlanRepository planRepo;
	@Autowired
	private PlanTypeMapper mapper;
	@Autowired
	private Validator validator;

	//-------------API to create PlanType -----------------------

		@PostMapping("/plantype")
		public ResponseEntity<Object> createPlanType(@Valid @RequestBody PlanTypeDto planTypeDto) {
				PlanType response = planTypeService.createPlanType(planTypeDto).getBody();
				return new ResponseHandler().generateSuccessResponse(response, HttpStatus.OK, Constants.SAVED);
		}
		

	//------------- API to fetch PlanType by PlanTypeId -----------------------
		@GetMapping("/plantype/{planTypeId}")
		public ResponseEntity<Object> getPlanType(@PathVariable int planTypeId) {
			PlanType response =  planTypeService.getPlanbyId(planTypeId).getBody();
			return new ResponseHandler().generateSuccessResponse(response, HttpStatus.OK, Constants.SUCCESS);
				
			
		}
}
