package com.example.plan.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.enums.PlanTypeEnum;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.repository.PlanTypeRepository;
import com.example.plan.services.PlanTypeService;

@SpringBootTest
@AutoConfigureMockMvc
public class testPlanTypeService {

	@MockBean
	private PlanTypeRepository planTypeRepository;
	@MockBean
	private PlanTypeMapper planTypeMapper;
	@Autowired
	private PlanTypeService planTypeService;

	// Set up the request object
	PlanTypeDto request = PlanTypeDto.builder().planTypeId(1).planName(PlanTypeEnum.ULIP).planCode(1).active(true)
			.build();

	// Set up the requested entity
	PlanType requestedEntity = PlanType.builder().planTypeId(1).planName(PlanTypeEnum.ULIP).planCode(1).active(true)
			.build();

	// Set up the expected entity
	PlanTypeDto expectedEntity = PlanTypeDto.builder().planTypeId(1).planName(PlanTypeEnum.ULIP).planCode(1)
			.active(true).createdBy("Admin").modifiedBy("Admin").createdDate(LocalDateTime.now())
			.modifiedDate(LocalDateTime.now()).build();

	// Set up the expected response

	PlanType expectedResponse = PlanType.builder().planTypeId(1).planName(PlanTypeEnum.ULIP).planCode(1).active(true)
			.createdBy("Admin").modifiedBy("Admin").createdDate(LocalDateTime.now()).modifiedDate(LocalDateTime.now())
			.build();
	
//------------------------------------------------------------------------------------
	@Test
	public void testAddPlanType() throws Exception {
		
		when(planTypeMapper.planTypeDtoToPlanType(request)).thenReturn(expectedResponse);
		when(planTypeRepository.save(requestedEntity)).thenReturn(expectedResponse);
		when(planTypeMapper.planTypeToPlanTypeDto(expectedResponse)).thenReturn(expectedEntity);

		PlanType response = planTypeService.createPlanType(request).getBody();
		// Assert the response object

		/*Assertions.assertEquals(response.getPlanName(), expectedResponse.getPlanName());
		Assertions.assertEquals(response.getPlanCode(), expectedResponse.getPlanCode());
		Assertions.assertEquals(response.getPlanTypeId(), expectedResponse.getPlanTypeId());
		Assertions.assertEquals(response.getCreatedBy(), expectedResponse.getCreatedBy());
		Assertions.assertEquals(response.getModifiedBy(), expectedResponse.getModifiedBy());*/
	}
//------------------------------------------------------------------------------------
	
	@Test
	public void testGetPlanTypeReturnFound() throws Exception{
		//int planTypeId =1;
		when(planTypeRepository.findById(any())).thenReturn(Optional.of(expectedResponse));
		
		PlanType response = planTypeService.getPlanbyId(any()).getBody();
		Assertions.assertEquals(response.getPlanTypeId(), expectedResponse.getPlanTypeId());
		Assertions.assertEquals(response.getPlanCode(), expectedResponse.getPlanCode());
		Assertions.assertEquals(response.getPlanName(), expectedResponse.getPlanName());
		
	}
//------------------------------------------------------------------------------------
	
	/*
	 * @Test public void testGetPlanTypeReturnNotFound() throws Exception{ int
	 * planTypeId =234;
	 * when(planTypeRepository.findById(planTypeId)).thenReturn(Optional.empty()); }
	 */
//------------------------------------------------------------------------------------
	
 }

