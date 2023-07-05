package com.example.plan.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_OccupationType")
public class OccupationType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OccupationType_seq_gen")
	@SequenceGenerator(name = "OccupationType_seq_gen", sequenceName = "OccupationType_seq")
	private int id;

 
	
	
	@Column(name = "occupationtype")
	private String occupationType;

	@Column(name = "state")
	private String state;

	@Column(name = "createdby")
	private String createdBy;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "createddate")
	private Date createdDate;

	@Column(name = "modifiedby")
	private String modifiedBy;
	 
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "modifieddate")
	private Date modifiedDate;

	@Column(name = "active")
	private String active;
	
	

	

}

	 

	 
	 

	 
	
	
	
	
	