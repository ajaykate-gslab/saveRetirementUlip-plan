package com.example.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.plan.entity.PlanType;

@Repository
public interface PlanTypeRepository extends JpaRepository<PlanType, Integer>{

}
