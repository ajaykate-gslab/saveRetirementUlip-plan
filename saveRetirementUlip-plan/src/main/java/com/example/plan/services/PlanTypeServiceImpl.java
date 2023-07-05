package com.example.plan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.plan.dto.PlanTypeDto;
import com.example.plan.entity.PlanType;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.repository.PlanTypeRepository;

@Service
public class PlanTypeServiceImpl implements PlanTypeService{

	@Autowired
	private PlanTypeRepository planTypeRepository;
	
	@Autowired
	private PlanTypeMapper planTypeMapper;

	//------------------------- Create PlanType -----------------------------------
		@Override
		public ResponseEntity<PlanType> createPlanType(PlanTypeDto planTypeDto) {
			return new ResponseEntity<PlanType>(planTypeRepository.save(planTypeMapper.planTypeDtoToPlanType(planTypeDto)), HttpStatus.CREATED);
		}

	//------------------------- get PlanType -----------------------------------
		@Override
		public ResponseEntity<PlanType> getPlanbyId(Integer plan_id) {
			Optional<PlanType> optionalPlanType = planTypeRepository.findById(plan_id);
			return new ResponseEntity<PlanType>(planTypeRepository.findById(plan_id).get(), HttpStatus.FOUND);
		}

}
