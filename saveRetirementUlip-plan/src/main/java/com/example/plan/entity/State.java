package com.example.plan.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "T_State")
public class State {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "state")
	private String state;

	@Column(name = "createdby")
	private String createdby;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "modifiedby")
	private String modifiedBy;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "modifieddate")
	private Date modifiedDate;
	 
	@Column(name = "active")
	private String active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	@JsonBackReference
	private Address address;

}