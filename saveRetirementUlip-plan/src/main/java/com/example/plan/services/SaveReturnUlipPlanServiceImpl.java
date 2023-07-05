package com.example.plan.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.plan.calculator.RetirementPlanCalculator;
import com.example.plan.calculator.SavingPlanCalculator;
import com.example.plan.calculator.UlipPlanCalculator;
import com.example.plan.dto.PlanResponse;
import com.example.plan.dto.SaveRetirementUlipPlanDto;
import com.example.plan.entity.PlanType;
import com.example.plan.entity.SaveRetirementUlipPlan;
import com.example.plan.entity.TCustomer;
import com.example.plan.enums.PlanTypeEnum;
import com.example.plan.mapper.PlanMapper;
import com.example.plan.repository.CustomerRepository;
import com.example.plan.repository.PlanTypeRepository;
import com.example.plan.repository.SaveRetirementUlipPlanRepository;
import com.example.plan.util.Constants;

@Service
@Component
public class SaveReturnUlipPlanServiceImpl extends SavingPlanCalculator implements SaveRetirementUlipPlanService {

	@Autowired
	private SaveRetirementUlipPlanRepository saveRetirementUlipPlanRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PlanTypeRepository planTypeRepository;

	@Autowired
	private PlanMapper planMapper;

	@Autowired
	private SavingPlanCalculator savingCalc;
	@Autowired
	private RetirementPlanCalculator retirementCalc;
	@Autowired
	private UlipPlanCalculator ulipCalc;

// ----------------------------------service to Create Plan by planType and customerId  ---------------------

	@Override
	public ResponseEntity<PlanResponse> createPlan(Integer planTypeId,
			SaveRetirementUlipPlanDto saveRetirementUlipPlanDto) {

		int customerId =(int) saveRetirementUlipPlanDto.getTCustomer().getId();
		// int planTypeId = saveRetirementUlipPlan.getPlanType().getPlanTypeId();

		Optional<TCustomer> optionalCustomer = customerRepository.findById( customerId);
		Optional<PlanType> optionalPlanType = planTypeRepository.findById(planTypeId);
		PlanTypeEnum planType = optionalPlanType.get().getPlanName();
		
		Map<String, Long> calculatedResult = null;
		PlanResponse response = null;
		
		if (optionalCustomer.isPresent()) {

			if (optionalPlanType.isPresent()) {
				saveRetirementUlipPlanDto.setTCustomer(optionalCustomer.get());
				saveRetirementUlipPlanDto.setPlanType(optionalPlanType.get());

				if (planType.name().equals(Constants.ULIP)) {
					Map<String, Object> calculatedResult2 = null;

					calculatedResult2 = ulipCalc.ulipPlanCalculator(saveRetirementUlipPlanDto);
					saveRetirementUlipPlanDto.setSavingPremium((long) calculatedResult2.get("result"));

				} else if (planType.name().equals(Constants.SAVING)) {
					calculatedResult = savingCalc.savingPlanCalculator(saveRetirementUlipPlanDto);
					saveRetirementUlipPlanDto.setSavingPremium(calculatedResult.get("premium"));
				
				} else if (planType.name().equals(Constants.RETIREMENT)) {

					calculatedResult = retirementCalc.retirementPlanCalculator(saveRetirementUlipPlanDto);
					saveRetirementUlipPlanDto.setSavingPremium(calculatedResult.get("coverAmountRoundOff"));
				}
				
				SaveRetirementUlipPlan plan = planMapper.toSaveRetirementUlipPlan(saveRetirementUlipPlanDto);
				PlanResponse planResponse= planMapper.toPlanResponse(saveRetirementUlipPlanRepository.save(plan));
				
				return new ResponseEntity<PlanResponse>(planResponse,
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity("PlanType Not Found", HttpStatus.NOT_FOUND);
			}
		}

		else {
			return new ResponseEntity("Customer Not Found", HttpStatus.NOT_FOUND);
		}

	}

// ---------------service to get Plan records by customerId --------------------------

	public ResponseEntity<List<SaveRetirementUlipPlan>> fetchPlanByCustomerId(Integer customerId) {
		Optional<TCustomer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isPresent()) {

			List<SaveRetirementUlipPlan> response = saveRetirementUlipPlanRepository.fetchPlanByCustomerId(customerId);
			if (response.size() > 0) {
				return new ResponseEntity<List<SaveRetirementUlipPlan>>(response, HttpStatus.FOUND);
			} else {
				return new ResponseEntity("No Plan found for the customer", HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity("Customer not found For this customerId", HttpStatus.NOT_FOUND);
		}

	}

}
