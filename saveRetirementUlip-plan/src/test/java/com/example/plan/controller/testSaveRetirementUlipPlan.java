package com.example.plan.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.mapper.PlanTypeMapper;
import com.example.plan.mapper.PlanTypeMapperImpl;
import com.example.plan.mapper.SaveRetirementUlipMapper;
import com.example.plan.services.SaveRetirementUlipPlanService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(SaveRetirementUlipController.class)
@AutoConfigureMockMvc
public class testSaveRetirementUlipPlan {
	@Autowired
    private MockMvc mockMvc;
	@Autowired
	private SaveRetirementUlipMapper mapper;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private SaveRetirementUlipController controller;
	@Autowired
	private SaveRetirementUlipPlanService service;
	
	@Test
    public void testAddUlipPlan() throws Exception {
        // Set up the request object
        SaveRetirementUlipPlanDto request = objectMapper.readValue(getClass().getResourceAsStream("/json/SaveRetirementUlipPlanDto.json"),SaveRetirementUlipPlanDto.class);

        // Set up the expected response object
        
        SaveRetirementUlipPlan expectedResponse = objectMapper.readValue(getClass().getResourceAsStream("/json/SaveRetirementUlipPlan.json"),SaveRetirementUlipPlan.class);

        when(service.createPlan(1,request)).thenReturn(new ResponseEntity<SaveRetirementUlipPlan>(expectedResponse,HttpStatus.CREATED));

        mockMvc.perform(MockMvcRequestBuilders.post("/oneappabc/adityabirla/api/v1/lifeinsurance/childplan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
               // .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(expectedResponse.getTCustomer().getFirstName()));
    }
	
	 
	
}
