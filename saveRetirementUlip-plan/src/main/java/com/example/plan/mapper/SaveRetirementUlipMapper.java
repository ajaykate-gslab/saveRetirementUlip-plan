package com.example.plan.mapper;

import org.mapstruct.Mapper;

import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.SaveRetirementUlipPlan;

@Mapper(componentModel = "spring")
public interface SaveRetirementUlipMapper {
	SaveRetirementUlipPlan toSaveRetirementUlipPlan(SaveRetirementUlipPlanDto dto);
	SaveRetirementUlipPlanDto toSaveRetirementUlipPlanDto(SaveRetirementUlipPlan plan);
}
