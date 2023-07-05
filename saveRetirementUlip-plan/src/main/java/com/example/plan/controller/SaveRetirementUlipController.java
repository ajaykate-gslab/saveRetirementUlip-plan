package com.example.plan.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.plan.dto.PlanResponse;
import com.example.plan.dto.ResponseHandler;
import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.services.SaveReturnUlipPlanServiceImpl;
import com.example.plan.util.Constants;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/oneabc/adityabirla/api/v1/lifeinsurance")
public class SaveRetirementUlipController {

	@Autowired
	private SaveReturnUlipPlanServiceImpl planService;

//-------------------- API to create Plan by PlanType and CustomerId ----------------------------

	@PostMapping("/plan/{planTypeId}")
	public ResponseEntity<Object> createPlan(@PathVariable Integer planTypeId,
			@Valid @RequestBody SaveRetirementUlipPlanDto saveRetirementUlipPlanDto) {
		PlanResponse response = planService.createPlan(planTypeId, saveRetirementUlipPlanDto).getBody();
		return new ResponseHandler().generateSuccessResponse(response, HttpStatus.OK,Constants.SAVED);
		//return planService.createPlan(planTypeId, saveRetirementUlipPlanDto);
	}

	
//-------------------- API to fetch PlanType by customerId ----------------------------
	@GetMapping("/plandetails")
	public ResponseEntity<Object> getAllPlanDetailsByCustomerId(
			@RequestParam Integer customerId) {
		
		List<SaveRetirementUlipPlan> response=  planService.fetchPlanByCustomerId(customerId).getBody();
		
		
		 return new ResponseHandler().generateSuccessResponse(response, HttpStatus.OK, Constants.SUCCESS);
			
		//return planService.fetchPlanByCustomerId(customerId);
	}

}
