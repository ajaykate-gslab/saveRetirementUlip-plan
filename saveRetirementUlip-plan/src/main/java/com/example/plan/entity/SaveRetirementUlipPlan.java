package com.example.plan.entity;


import java.time.Instant;
import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "T_SAV_RET_ULIP_PLAN")	
public class SaveRetirementUlipPlan { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer savingId;  // PK
	
	//private int customerId; //  NOTNULL_FK	Master Managed T_CUSTOMER
	//private int planType;  // NOTNULL_FK	Master Managed T_LI_PLANTYPE
	
	@Column(name ="savingTenureYrs")
	@NonNull
	private int savingTenureYrs; //	 NOTNULL
	
	@Column(name = "savingPremium")
	private double savingPremium;
	
	@NonNull
	@Column(name = "savingAmt")	
	private double savingAmt;	

	@NonNull
	@Column(name = "savingMaturityYrs")
	private int savingMaturityYrs; // NOTNULL

	@NonNull
	@Column(name = "roi")
	private int roi; // NOTNULL	

	@Column(name = "createdBy")
	private String createdBy;	

	@CurrentTimestamp
	@Column(name = "createdDate")
	private Instant createdDate;	//TIMESTAMP	

	@Column(name = "modifiedBy")
	private String modifiedBy;	

	@UpdateTimestamp
	@Column(name = "modifiedDate")
	private Instant modifiedDate; //	TIMESTAMP

	@NonNull
	@Column(name = "active")
	private boolean active;	
	/*
	 * @OneToOne
	 * @JoinColumn(name = "customerId", referencedColumnName = "id")
	 */
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private TCustomer tCustomer;
	
	@ManyToOne
	@JoinColumn(name = "plan_type_id")
	private PlanType planType;
}
