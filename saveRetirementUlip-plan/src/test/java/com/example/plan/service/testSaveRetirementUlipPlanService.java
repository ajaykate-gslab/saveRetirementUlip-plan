package com.example.plan.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.dto.TCustomerDto;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.entity.TCustomer;
import com.example.plan.enums.PlanTypeEnum;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.mapper.SaveRetirementUlipMapper;
import com.example.plan.repository.CustomerRepository;
import com.example.plan.repository.PlanTypeRepository;
import com.example.plan.repository.SaveRetirementUlipPlanRepository;
import com.example.plan.services.PlanTypeService;
import com.example.plan.services.SaveRetirementUlipPlanService;

@SpringBootTest
public class testSaveRetirementUlipPlanService {

	@MockBean
	private PlanTypeRepository planTypeRepository;
	@MockBean
	private SaveRetirementUlipPlanRepository planRepository;
	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	private PlanTypeMapper planTypeMapper;
	@MockBean
	private SaveRetirementUlipMapper planMapper;
	@Autowired
	private PlanTypeService planTypeService;
	@Autowired
	private SaveRetirementUlipPlanService planService;

	// Set up the request object
	PlanTypeDto request = PlanTypeDto.builder().planTypeId(1).planName(PlanTypeEnum.ULIP).planCode(1).active(true)
			.build();

	// Set up the requested entity
	PlanType requestedEntity = PlanType.builder().planTypeId(1).planName(PlanTypeEnum.ULIP).planCode(1).active(true)
			.build();

	// Set up the expected entity
	PlanTypeDto expectedEntity = PlanTypeDto.builder().planTypeId(1).planName(PlanTypeEnum.ULIP).planCode(1)
			.active(true).createdBy("Aman").modifiedBy("Aman").createdDate(LocalDateTime.now())
			.modifiedDate(LocalDateTime.now()).build();

	// Set up the expected response

	PlanType expectedResponse = PlanType.builder().planTypeId(1).planName(PlanTypeEnum.ULIP).planCode(1).active(true)
			.createdBy("Aman").modifiedBy("Aman").createdDate(LocalDateTime.now()).modifiedDate(LocalDateTime.now())
			.build();
	// ---
	TCustomer customerEntity = TCustomer.builder().customerId(1).firstName("Ajay").lastName("Kate").active(true)
			.createdBy("Ajay").modifiedBy("Ajay").createdDate(LocalDateTime.now()).modifiedDate(LocalDateTime.now())
			.build();

	TCustomerDto customerDto = TCustomerDto.builder().customerId(1).firstName("Ajay").lastName("Kate").active(true)
			.createdBy("Ajay").modifiedBy("Ajay").createdDate(LocalDateTime.now()).modifiedDate(LocalDateTime.now())
			.build();
	// ---
	SaveRetirementUlipPlan planEntity = SaveRetirementUlipPlan.builder().savingId(1).savingTenureYrs(20)
			.savingPremium(4800000.0).savingAmt(16000.0).savingMaturityYrs(25).roi(4).active(true).createdBy("Aman")
			.modifiedBy("Aman").planType(expectedResponse).tCustomer(customerEntity).build();
	SaveRetirementUlipPlan planEntity2 = SaveRetirementUlipPlan.builder().savingId(2).savingTenureYrs(20)
			.savingPremium(4800000.0).savingAmt(16000.0).savingMaturityYrs(25).roi(4).active(true).createdBy("Aman")
			.modifiedBy("Aman").planType(expectedResponse).tCustomer(customerEntity).build();

	SaveRetirementUlipPlanDto planDto = SaveRetirementUlipPlanDto.builder().savingId(1).savingTenureYrs(20)
			.savingPremium(4800000.0).savingAmt(16000.0).savingMaturityYrs(25).roi(4).active(true).createdBy("Aman")
			.modifiedBy("Aman").planType(expectedResponse).tCustomer(customerEntity).build();

	// ---

	List<SaveRetirementUlipPlan> planList = new ArrayList<>();

	@Test
	public void testAddPlanRecordFound() throws Exception {
			
		when(customerRepository.findById(any())).thenReturn(Optional.of(customerEntity));
		when(planTypeRepository.findById(any())).thenReturn(Optional.of(expectedResponse));
		when(planRepository.save(any())).thenReturn(planEntity);
			
		SaveRetirementUlipPlan response = planService.createPlan(any(),planDto).getBody();
		// Assert the response object
			
		Assertions.assertEquals(response.getSavingAmt(), planEntity.getSavingAmt());
		Assertions.assertEquals(response.getSavingTenureYrs(), planEntity.getSavingTenureYrs());
	}
// ----

	@Test
	private void testGetPlanByCustomerIdRecordFound() throws Exception{
		when(customerRepository.findById(any())).thenReturn(Optional.of(customerEntity));
		planList.add(planEntity);
		planList.add(planEntity2);
		when(planRepository.fetchPlanByCustomerId(any())).thenReturn(planList);
		
		List<SaveRetirementUlipPlan> response = planRepository.fetchPlanByCustomerId(any());
			
		Assertions.assertEquals(response.size(), planList.size());
		Assertions.assertEquals(response.get(0).getSavingId(),planList.get(0).getSavingId());
		Assertions.assertEquals(response.get(1).getSavingId(), planList.get(1).getSavingId());
		Assertions.assertEquals(response.get(0).getPlanType().getPlanName(),planList.get(0).getPlanType().getPlanName());
		Assertions.assertEquals(response.get(1).getPlanType().getPlanName(),planList.get(1).getPlanType().getPlanName());
	}

}
