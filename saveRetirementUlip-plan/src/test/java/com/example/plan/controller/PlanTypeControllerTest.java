package com.example.plan.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.entity.PlanType;
import com.example.plan.enums.PlanTypeEnum;
import com.example.plan.services.PlanTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@WebMvcTest(PlanTypeController.class)
public class PlanTypeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PlanTypeService planTypeService;
	
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	
	PlanTypeDto request = new PlanTypeDto();
	PlanType response = new PlanType();
	
	@BeforeEach
	void init() {
		PlanTypeDto request = new PlanTypeDto();
		request.setPlanName(PlanTypeEnum.ULIP);
		request.setPlanCode(2);
		request.setActive(true);
		
		PlanType response = new PlanType();
		response.setPlanTypeId(1);
		response.setPlanCode(2);
		response.setPlanName(PlanTypeEnum.ULIP);
		response.setCreatedBy("Admin");
		response.setCreatedDate(LocalDateTime.now());
		response.setModifiedBy("Admin");
		response.setModifiedDate(LocalDateTime.now());
		response.setActive(true);
	}
	
	@Test
	public void testAddPlanType() throws Exception {
		ResponseEntity<PlanType> expectedResponse = new ResponseEntity<PlanType>(response,HttpStatus.CREATED);
		 when(planTypeService.createPlanType(request)).thenReturn(expectedResponse);
		
		 mockMvc.perform(post("/oneabc/adityabirla/api/v1/lifeinsurance/plantype")
        .contentType(APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
		 .andExpect(status().isCreated())
		 .andExpect(jsonPath("$", aMapWithSize(7)))
		 .andDo(print());
		 
		
	}
	
}
