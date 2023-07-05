package com.example.plan.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "T_PINMGT")
public class PinMgt {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "currentmpin")
	private String currentMpin;

	@Column(name = "mpinexpiry")
	private Date mpinExpiry;

	@Column(name = "createdby")
	private String createdBy;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "createddate")
	private Date createdDate;
	
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "modifieddate")
	private Date modifiedDate;

	@Column(name = "modifiedby")
	private String modifiedBy;
	
	@Column(name = "active")
	private String active;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cust_id")
	private TCustomer customer;
	}