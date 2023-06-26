package com.example.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.plan.entity.TCustomer;

@Repository
public interface CustomerRepository extends JpaRepository<TCustomer, Integer>{

}
