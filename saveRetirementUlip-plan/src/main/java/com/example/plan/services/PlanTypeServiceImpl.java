package com.example.plan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.plan.entity.PlanType;
import com.example.plan.mapper.SaveRetirementUlipMapper;
import com.example.plan.repository.CustomerRepository;
import com.example.plan.repository.PlanTypeRepository;
import com.example.plan.repository.SaveRetirementUlipPlanRepository;

@Service
public class PlanTypeServiceImpl implements PlanTypeService{
 
	@Autowired
	private SaveRetirementUlipPlanRepository saveRetirementUlipPlanRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PlanTypeRepository planTypeRepository;

	@Autowired
	private SaveRetirementUlipMapper PlanMapper;

	//------------------------- Create PlanType -----------------------------------
		@Override
		public ResponseEntity<PlanType> createPlanType(PlanType planType) {
			return new ResponseEntity<PlanType>(planTypeRepository.save(planType), HttpStatus.CREATED);
		}

	//------------------------- get PlanType -----------------------------------
		@Override
		public ResponseEntity<PlanType> getPlanbyId(Integer plan_id) {
			Optional<PlanType> optionalPlanType = planTypeRepository.findById(plan_id);
			return new ResponseEntity<PlanType>(planTypeRepository.findById(plan_id).get(), HttpStatus.FOUND);
			/*
			 * if (optionalPlanType.isPresent()) { return new
			 * ResponseEntity<PlanType>(planTypeRepository.findById(plan_id).get(),
			 * HttpStatus.FOUND); } else { return new
			 * ResponseEntity("plan type not found",HttpStatus.NOT_FOUND); }
			 */
		}

		// --
}
