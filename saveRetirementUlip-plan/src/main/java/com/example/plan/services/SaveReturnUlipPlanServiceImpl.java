package com.example.plan.services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.entity.TCustomer;
import com.example.plan.enums.PlanTypeEnum;
import com.example.plan.mapper.SaveRetirementUlipMapper;
import com.example.plan.repository.CustomerRepository;
import com.example.plan.repository.PlanTypeRepository;
import com.example.plan.repository.SaveReturnUlipPlanRepository;
import com.example.plan.util.Constants;

@Service
public class SaveReturnUlipPlanServiceImpl implements SaveRetirementUlipPlanService {

	@Autowired
	private SaveReturnUlipPlanRepository saveReturnUlipPlanRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PlanTypeRepository planTypeRepository;
	
	@Autowired
	private SaveRetirementUlipMapper PlanMapper;

// ---------------------------------- Create Plan  ---------------------
	@Override
	public ResponseEntity<SaveRetirementUlipPlan> createPlan(Integer planTypeId,
			SaveRetirementUlipPlanDto saveRetirementUlipPlanDto) {
		
		
		int customerId = saveRetirementUlipPlanDto.getTCustomer().getCustomerId();
		// int planTypeId = saveRetirementUlipPlan.getPlanType().getPlanTypeId();

		Optional<TCustomer> optionalCustomer = customerRepository.findById(customerId);
		Optional<PlanType> optionalPlanType = planTypeRepository.findById(planTypeId);
		PlanTypeEnum planType = optionalPlanType.get().getPlanName();
		
		
		/*
		 * ****** IF WE NEED TO USE REST TEMPLATE FOR INDIVIDUAL WE CAN USE THIS *****
		 * if(planType.name().equals(Constants.ULIP)) return new
		 * ResponseEntity("ULIP plan",HttpStatus.OK); } else
		 * if(planType.name().equals(Constants.SAVING)) { return new
		 * ResponseEntity("SAVING plan",HttpStatus.OK); } else
		 * if(planType.name().equals(Constants.RETIREMENT)) { return new
		 * ResponseEntity("RETIREMENT plan",HttpStatus.OK); }else { return new
		 * ResponseEntity("OTHER plan",HttpStatus.OK); }
		 */

		if (optionalCustomer.isPresent()) {

			if (optionalPlanType.isPresent()) {
				saveRetirementUlipPlanDto.setSavingPremium(4800000);
				saveRetirementUlipPlanDto.setTCustomer(optionalCustomer.get());
				saveRetirementUlipPlanDto.setPlanType(optionalPlanType.get());

				return new ResponseEntity<SaveRetirementUlipPlan>(
						saveReturnUlipPlanRepository.save(PlanMapper.toSaveRetirementUlipPlan(saveRetirementUlipPlanDto)), HttpStatus.CREATED);
			} else {
				return new ResponseEntity("PlanType Not Found", HttpStatus.NOT_FOUND);
			}
		}
		
		else {
			return new ResponseEntity("Customer Not Found", HttpStatus.NOT_FOUND);
		}	

	}

// --------------- to get Plan records by customerId --------------------------
	
	public ResponseEntity<List<SaveRetirementUlipPlan>> fetchPlanByCustomerId(Integer customerId) {
		Optional<TCustomer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isPresent()) {

			List<SaveRetirementUlipPlan> response=  saveReturnUlipPlanRepository.fetchPlanByCustomerId(customerId);
			if(response.size()>0) {
				return new ResponseEntity<List<SaveRetirementUlipPlan>>(response,HttpStatus.FOUND);
			}
			else {
				return new ResponseEntity("No Plan found for the customer",HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity("Customer not found For this customerId",HttpStatus.NOT_FOUND);
		}
		
	}
	
	
//------------------------- Create PlanType -----------------------------------
	@Override
	public ResponseEntity<PlanType> createPlanType(PlanType planType) {
		return new ResponseEntity<PlanType>(planTypeRepository.save(planType),HttpStatus.CREATED);
	}

//------------------------- get PlanType -----------------------------------
	@Override
	public ResponseEntity<PlanType> getPlanbyId(Integer plan_id) {
	Optional<PlanType> optionalPlanType = planTypeRepository.findById(plan_id);
	
	if (optionalPlanType.isPresent()) {
		return new ResponseEntity<PlanType>(planTypeRepository.findById(plan_id).get(),HttpStatus.FOUND);
	}
	else {
		return new ResponseEntity("plan type not found",HttpStatus.NOT_FOUND);
	}
}
	
	//--

	
	
	
	
	
	
	
	
	
}
