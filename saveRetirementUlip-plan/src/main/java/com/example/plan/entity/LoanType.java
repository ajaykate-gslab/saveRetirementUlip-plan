package com.example.plan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "T_LoanType")
public class LoanType {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq_gen")
    @SequenceGenerator(name = "loan_seq_gen", sequenceName = "loan_seq")
	private long id;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonBackReference
    private TCustomer customer;
	
	
	@Column(name = "loantype")
	private String loanType;
	
	@Column(name = "createdby")
	private String createdby;
	
	@Column(name = "createddate")
	private String createddate;
	
	@Column(name = "modifiedby")
	private String modifiedBy;
	
	@Column(name = "modifieddate")
	private String modifiedDate;
	
	 
	@Column(name = "active")
	private String active;
}