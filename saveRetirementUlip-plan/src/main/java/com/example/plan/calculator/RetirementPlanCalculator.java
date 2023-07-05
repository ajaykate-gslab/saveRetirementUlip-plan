package com.example.plan.calculator;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.formula.functions.Finance;
import org.springframework.stereotype.Service;
import com.example.plan.dto.SaveRetirementUlipPlanDto;

@Service
public  class RetirementPlanCalculator {
	private static final long PENSION_TO_BE_PROVIDE = 15;
	private static final double ROR = 0.06d;

	public Map<String, Long> retirementPlanCalculator(SaveRetirementUlipPlanDto parameters) {
		System.out.println("Request : "+parameters);
		double monthlyPension = roundAvoid(fv(parameters.getRoi() / 100, parameters.getSavingTenureYrs(), 0,
				-parameters.getSavingAmt(), 1), 2);
		
		long corpousAtRetirement = roundCeilLakh(monthlyPension * 12 * PENSION_TO_BE_PROVIDE);
		double pmt = pmt(ROR / 12, parameters.getSavingTenureYrs() * 12, 0, -corpousAtRetirement, 1);
		long pmtRoundOff = roundCeil(pmt);
		long coverAmount = (long) ((pmtRoundOff * 12) * parameters.getSavingTenureYrs()* 1.05);
		long coverAmountRoundOff = roundFloorLakh(coverAmount);

		Map<String, Long> result = new HashMap<>();
		result.put("corpousAtRetirement", corpousAtRetirement);
		result.put("premiumRoundOff", pmtRoundOff); //16000
		result.put("coverAmount", coverAmount); //4800000
		result.put("coverAmountRoundOff", coverAmountRoundOff);
		return result;
	}

	double pmt(double r, int nper, double pv, long fv, int type) {
		return -r * (pv * Math.pow(1 + r, nper) + fv) / ((1 + r * type) * (Math.pow(1 + r, nper) - 1));
	}

	double fv(double r, int nper, double pmt, double pv, int type) {
		return -(pv * Math.pow(1 + r, nper) + pmt * (1 + r * type) * (Math.pow(1 + r, nper) - 1) / r);
	}

	long roundCeil(double input) {
		long i = (long) Math.ceil(input);
		return ((i + 99) / 100) * 100;
	}

	long roundCeilLakh(double input) {
		long i = (long) Math.ceil(input);
		return ((i + 99999) / 100000) * 100000;
	}

	long roundFloorLakh(double input) {
		long i = (long) Math.floor(input);
		
		i = i/100000;
		return i * 100000;
	}

	double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}
}
