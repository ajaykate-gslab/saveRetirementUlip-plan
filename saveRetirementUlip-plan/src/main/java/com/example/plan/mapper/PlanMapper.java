package com.example.plan.mapper;

import org.springframework.stereotype.Component;

import com.example.plan.dto.PlanResponse;
import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.SaveRetirementUlipPlan;

@Component
public class PlanMapper {
	
		public SaveRetirementUlipPlan toSaveRetirementUlipPlan(SaveRetirementUlipPlanDto dto) {
			if (dto == null) {
				return null;
			}
			
			SaveRetirementUlipPlan plan= new SaveRetirementUlipPlan();
			
			plan.setSavingId(dto.getSavingId());
			plan.setSavingMaturityYrs(dto.getSavingMaturityYrs());
			plan.setSavingAmt(dto.getSavingAmt());
			plan.setActive(dto.getActive());
			plan.setCreatedBy(dto.getCreatedBy());
			plan.setRoi(dto.getRoi());
			plan.setModifiedBy(dto.getModifiedBy());
			plan.setModifiedDate(dto.getModifiedDate());
			plan.setCreatedDate(dto.getCreatedDate());
			plan.setSavingPremium(dto.getSavingPremium());
			plan.setSavingTenureYrs(dto.getSavingTenureYrs());
			plan.setTCustomer(dto.getTCustomer());
			plan.setPlanType(dto.getPlanType());
			return plan;
			

		}

		public SaveRetirementUlipPlanDto toSaveRetirementUlipPlanDto(SaveRetirementUlipPlan plan) {
			if (plan == null) {
				return null;
			}

			SaveRetirementUlipPlanDto dto = new SaveRetirementUlipPlanDto();

			dto.setSavingId(plan.getSavingId());
			dto.setSavingTenureYrs(plan.getSavingTenureYrs());
			dto.setSavingPremium(plan.getSavingPremium());
			dto.setSavingAmt(plan.getSavingAmt());
			dto.setSavingMaturityYrs(plan.getSavingMaturityYrs());
			dto.setRoi(plan.getRoi());
			dto.setCreatedBy(plan.getCreatedBy());
			dto.setCreatedDate(plan.getCreatedDate());
			dto.setModifiedBy(plan.getModifiedBy());
			dto.setModifiedDate(plan.getModifiedDate());
			dto.setActive(plan.getActive());
			dto.setTCustomer(plan.getTCustomer());
			dto.setPlanType(plan.getPlanType());

			return dto;
		}
		
		public PlanResponse toPlanResponse(SaveRetirementUlipPlan plan) {
			if (plan == null) {
				return null;
			}

			PlanResponse response = new PlanResponse();

			response.setSavingId(plan.getSavingId());
			response.setSavingTenureYrs(plan.getSavingTenureYrs());
			response.setSavingPremium(plan.getSavingPremium());
			response.setSavingAmt(plan.getSavingAmt());
			response.setSavingMaturityYrs(plan.getSavingMaturityYrs());
			response.setRoi(plan.getRoi());
			response.setCreatedBy(plan.getCreatedBy());
			response.setCreatedDate(plan.getCreatedDate());
			response.setModifiedBy(plan.getModifiedBy());
			response.setModifiedDate(plan.getModifiedDate());
			response.setActive(plan.getActive());
			response.setCustomerId(plan.getTCustomer().getId());
			response.setPlanTypeId(plan.getPlanType().getPlanTypeId());
			response.setPlanName(plan.getPlanType().getPlanName());
			return response;
		}
	
}
