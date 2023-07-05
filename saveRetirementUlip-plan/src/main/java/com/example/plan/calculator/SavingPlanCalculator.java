package com.example.plan.calculator;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.plan.dto.SaveRetirementUlipPlanDto;

@Service
public class SavingPlanCalculator {

	private static final float EXPECTED_ROR = 0.06f;
	private static final int PRESENT_VALUE = 0;
	private static final int TYPE = 1;
	
	public Map<String, Long> savingPlanCalculator(SaveRetirementUlipPlanDto plan) {
		double investTillThisAmount = Math.round(investTillThisAmount(plan.getSavingAmt(), EXPECTED_ROR,//getSavingPremium()
				plan.getSavingTenureYrs(), plan.getSavingMaturityYrs()));
		long pmt = roundCeil(pmt(EXPECTED_ROR / 12, plan.getSavingMaturityYrs() * 12, PRESENT_VALUE,
				investTillThisAmount, TYPE));
		long coverAmount = roundFloor(coverAmount(pmt));
		Map<String, Long> result = new HashMap<>();
		result.put("premium", pmt);
		result.put("cover_amount", coverAmount);
		return result;
	}


	public double investTillThisAmount(double savingGoal, float expectedROR, int stayInvested, int premiumPayingTerm) {
		return -savingGoal / Math.pow((1 + expectedROR), (stayInvested - premiumPayingTerm));
	}

	public double pmt(float expectedROR, int premiumPayingTerm, int presentValue, double investTillThisAmount,
			int type) {
		return -expectedROR * (presentValue * Math.pow(1 + expectedROR, premiumPayingTerm) + investTillThisAmount)
				/ ((1 + expectedROR * type) * (Math.pow(1 + expectedROR, premiumPayingTerm) - 1));
	}
	
	public long coverAmount(long pmt) {
		return 10 * (pmt * 12);
	}
	
	public long roundCeil(double input) {
		long i = (long) Math.ceil(input);
		return ((i + 99) / 100) * 100;
	}

	public long roundFloor(double input) {
		long i = (long) Math.floor(input);
		return ((i - 9999) / 100000) * 100000;
	}
}
