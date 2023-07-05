package com.example.plan.calculator;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.plan.dto.SaveRetirementUlipPlanDto;

@Service
public  class UlipPlanCalculator {

	public Map<String, Object> ulipPlanCalculator(SaveRetirementUlipPlanDto ulipPlan) {
		double coverAmount=10*(ulipPlan.getSavingAmt()*12);
        long coverAmountRoundOff= roundFloor(coverAmount);;
        double after_invest = fv(ulipPlan.getRoi()/1200, (int) (ulipPlan.getSavingMaturityYrs()*12),-ulipPlan.getSavingAmt()*0.9,0,1);
        double after_investRoundOff=roundAvoid(after_invest,2);
        double you_get=roundAvoid(fv(ulipPlan.getRoi()/100, (int)(ulipPlan.getSavingTenureYrs()-ulipPlan.getSavingMaturityYrs()),0,-after_investRoundOff,1),2);
        long yougetRoundOff= roundFloor(you_get);
        Map<String, Object> output = new HashMap<>();
        output.put("Cover Amount", coverAmount);
        output.put("Cover Amount(round off)", Math.round(coverAmountRoundOff));
        output.put("After invest for(years)", after_invest);
        output.put("After invest for(yrs) Round off", after_investRoundOff);
        output.put("you get", you_get);
        output.put("result",yougetRoundOff);
		return output;
    }
    public static long roundFloor(double input) {
        long i = (long) Math.floor(input);
        return ((i) / 100000) * 100000;
    }
    static double pmt(double rate_of_return, double invest_for, double pv, long investfor,int type) {
        return rate_of_return * (pv * Math.pow(1 + rate_of_return, invest_for)+investfor ) / ((1 + rate_of_return*type) * (Math.pow(1 + rate_of_return, invest_for) - 1));
    }
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
        public static double fv(double r, int nper, double pmt, double pv, int type) {
        return -(pv * Math.pow(1 + r, nper) + pmt * (1+r*type) * (Math.pow(1 + r, nper) - 1) / r);
	}
}
