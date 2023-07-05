package com.example.plan.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.entity.TCustomer;
import com.example.plan.enums.PlanTypeEnum;
import com.example.plan.mapper.PlanMapper;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.repository.CustomerRepository;
import com.example.plan.repository.PlanTypeRepository;
import com.example.plan.repository.SaveRetirementUlipPlanRepository;
import com.example.plan.services.PlanTypeService;
import com.example.plan.services.SaveRetirementUlipPlanService;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@SpringBootTest
@AutoConfigureMockMvc
public class testSaveRetirementUlipPlanService {
/*
	@MockBean
	private PlanTypeRepository planTypeRepository;
	@MockBean
	private SaveRetirementUlipPlanRepository planRepository;
	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	private PlanTypeMapper planTypeMapper;
	@MockBean
	private PlanMapper planMapper;
	@Autowired
	private PlanTypeService planTypeService;
	@Autowired
	private SaveRetirementUlipPlanService planService;

	public static TCustomer getCustomer() {
		TCustomer customerRequest = new TCustomer();
		customerRequest.setId(1);
		customerRequest.setMobileNumber("1234567890");
		customerRequest.setFirstName("John");
		customerRequest.setLastName("Doe");
		customerRequest.setDateOfBirth(new Date(2000,2,2));
		customerRequest.setKycCoustomer(new ArrayList<>());  // Assuming you have an empty list of Kyc objects
		customerRequest.setLoanType(new ArrayList<>());     // Assuming you have an empty list of LoanType objects
		customerRequest.setPanNumber("ABCDE12345");
		customerRequest.setAdharNumber("123456789012");
		customerRequest.setEmail("john.doe@example.com");
		customerRequest.setGender("Male");
		customerRequest.setAddress(new ArrayList<>());      // Assuming you have an empty list of Address objects
		customerRequest.setLandmark("Landmark");
		customerRequest.setPincode("123456");
		//customer.setOccupationType(new OccupationType());  // Assuming you have an instance of OccupationType
		customerRequest.setCompanyName("ABC Company");
		customerRequest.setNriCustomer(false);
		customerRequest.setMonthlyIncome("5000");
		customerRequest.setLoanAmount("10000");
		customerRequest.setCreatedBy("Admin");
		//customer.setCreatedDate(new Date());
		customerRequest.setModifiedBy("Admin");
		//customer.setModifiedDate(new Date(2023,10,10));
		customerRequest.setActive("Yes");
		customerRequest.setEnableDHA("Enabled");
		//customer.setMpin(new PinMgt());  // Assuming you have an instance of PinMgt
		return customerRequest;
	}
	
	public static PlanTypeDto getPlanTypeRequest() {
		PlanTypeDto planType = new PlanTypeDto();
		planType.setPlanTypeId(1);
		planType.setPlanName(PlanTypeEnum.SAVING);
		planType.setCreatedBy("Admin");
		planType.setCreatedDate(LocalDateTime.now());
		planType.setModifiedBy("Admin");
		planType.setModifiedDate(LocalDateTime.now());
		planType.setActive(true);
		return planType;
	}
	
	public static PlanType getPlanTypeResponse() {
		PlanType planType = new PlanType();
		planType.setPlanTypeId(1);
		planType.setPlanName(PlanTypeEnum.SAVING);
		planType.setCreatedBy("Admin");
		planType.setCreatedDate(LocalDateTime.now());
		planType.setModifiedBy("Admin");
		planType.setModifiedDate(LocalDateTime.now());
		planType.setActive(true);
		return planType;
	}
	
	public static SaveRetirementUlipPlan getPlanResponse() {
		
		SaveRetirementUlipPlan response = new SaveRetirementUlipPlan();
		response.setSavingId(1);
		response.setSavingAmt(16000.0);
		response.setActive(true);
		response.setCreatedBy("Aman");
		response.setCreatedBy("Aman");
		response.setCreatedDate(LocalDateTime.now());
		response.setModifiedDate(LocalDateTime.now());
		response.setRoi(4.0);
		response.setSavingMaturityYrs(20);
		response.setSavingTenureYrs(10);
		response.setSavingPremium(4800000L);
		response.setTCustomer(getCustomer());
		response.setPlanType(getPlanTypeResponse());		
		return response;
	}
	
	public static SaveRetirementUlipPlanDto getPlanRequest() {
		SaveRetirementUlipPlanDto request = new SaveRetirementUlipPlanDto();
		return request;
	}
	
	List<SaveRetirementUlipPlan> planList = new ArrayList<>();

	@Test
	public void testAddPlanRecordFound() throws Exception {
		TCustomer customerResponse = getCustomer();
		PlanType planTypeResponse = getPlanTypeResponse();
		PlanTypeDto planTypeRequest = getPlanTypeRequest();
		SaveRetirementUlipPlan planResponse = getPlanResponse();
		SaveRetirementUlipPlanDto planRequest = getPlanRequest();
		
		when(customerRepository.findById(any())).thenReturn(Optional.of(customerResponse));
		when(planTypeRepository.findById(any())).thenReturn(Optional.of(planTypeResponse));
		when(planRepository.save(planResponse)).thenReturn(planResponse);
			
		//SaveRetirementUlipPlan response = planService.createPlan(any(),planRequest).getBody();
		// Assert the response object
			
		//Assertions.assertEquals(response.getSavingAmt(), planResponse.getSavingAmt());
		//Assertions.assertEquals(response.getSavingTenureYrs(), planResponse.getSavingTenureYrs());
	}
// ----

	@Test
	private void testGetPlanByCustomerIdRecordFound() throws Exception{
		TCustomer customerResponse = getCustomer();
		PlanType planTypeResponse = getPlanTypeResponse();
		when(customerRepository.findById(any())).thenReturn(Optional.of(customerResponse));
		planList.add(planTypeResponse);
		planList.add(customerResponse);
		when(planRepository.fetchPlanByCustomerId(any())).thenReturn(planList);
		
		List<SaveRetirementUlipPlan> response = planRepository.fetchPlanByCustomerId(any());
			
		Assertions.assertEquals(response.size(), planList.size());
		Assertions.assertEquals(response.get(0).getSavingId(),planList.get(0).getSavingId());
		Assertions.assertEquals(response.get(1).getSavingId(), planList.get(1).getSavingId());
		Assertions.assertEquals(response.get(0).getPlanType().getPlanName(),planList.get(0).getPlanType().getPlanName());
		Assertions.assertEquals(response.get(1).getPlanType().getPlanName(),planList.get(1).getPlanType().getPlanName());
	}
	
	*/

}
