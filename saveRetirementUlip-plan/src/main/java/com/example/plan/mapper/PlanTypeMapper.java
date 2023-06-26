package com.example.plan.mapper;

import org.mapstruct.Mapper;

import com.example.plan.dto.PlanTypeDto;
import com.example.plan.entity.PlanType;

@Mapper(componentModel = "spring")
public interface PlanTypeMapper {

	PlanType planTypeDtoToPlanType(PlanTypeDto planTypeDto);
	PlanTypeDto planTypeToPlanTypeDto(PlanType planType);
}
