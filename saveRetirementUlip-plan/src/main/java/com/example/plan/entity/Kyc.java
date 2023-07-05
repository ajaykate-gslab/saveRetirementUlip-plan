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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "T_Kyc") 
public class Kyc {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kyc_seq_gen")
    @SequenceGenerator(name = "kyc_seq_gen", sequenceName = "kyc_seq")
	private long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonBackReference
    private TCustomer customer;
	
	 
	
	@Column(name = "permanentaddress")
	private String permanentAddress;
	
	@Column(name = "digilockerstatus")
	private String digilockerStatus;
	
	@Column(name = "digilockercreateddate")
	private String digilockerCreatedDate;
	
	@Column(name = "videokyc")
	private String videoKYC;
	
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "lastfetcheddt")
	private Date lastFetchedDT;

	 
	
}