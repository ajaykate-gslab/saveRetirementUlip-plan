package com.example.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.entity.PlanType;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.repository.SaveRetirementUlipPlanRepository;
import com.example.plan.services.PlanTypeServiceImpl;
import com.example.plan.services.SaveReturnUlipPlanServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.Validator;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/lifeinsurance")
public class PlanTypeController {


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

	//------------- Plan Type APIs -----------------------

		@PostMapping("/plantype")
		public ResponseEntity<PlanType> createPlanType(@Valid @RequestBody PlanTypeDto planTypeDto) {
				//if (List.of(PlanTypeEnum.values()).contains(planTypeDto.getPlanName())) 
					return planTypeService.createPlanType(mapper.planTypeDtoToPlanType(planTypeDto));	 
		}

		@GetMapping("/plantype/{planTypeId}")
		public ResponseEntity<PlanType> getPlanType(@PathVariable int planTypeId) {
			return planTypeService.getPlanbyId(planTypeId);
		}
}
