package com.example.plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.plan.entity.SaveRetirementUlipPlan;

@Repository
public interface SaveReturnUlipPlanRepository extends JpaRepository<SaveRetirementUlipPlan, Integer>, JpaSpecificationExecutor<SaveRetirementUlipPlan>{
	
	//List<SaveRetirementUlipPlan> findByTCustomerCustomerId(Integer customerId);
	

	@Query(value = "SELECT * FROM abcd.t_sav_ret_ulip_plan where customer_id=:customer_id",nativeQuery = true)
	public List<SaveRetirementUlipPlan> fetchPlanByCustomerId(@Param("customer_id") Integer customerId);


}
