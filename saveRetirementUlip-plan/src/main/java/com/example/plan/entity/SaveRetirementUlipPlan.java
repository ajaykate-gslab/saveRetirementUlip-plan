package com.example.plan.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "T_SAV_RET_ULIP_PLAN")	
public class SaveRetirementUlipPlan { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer savingId;  // PK
	
	//private int customerId; //  NOTNULL_FK	Master Managed T_CUSTOMER
	//private int planType;  // NOTNULL_FK	Master Managed T_LI_PLANTYPE
	
	@Column(name ="savingTenureYrs")
	@NonNull
	private Integer savingTenureYrs; //	 NOTNULL
	
	@Column(name = "savingPremium")
	private Double savingPremium;
	
	@NonNull
	@Column(name = "savingAmt")	
	private Double savingAmt;	

	@NonNull
	@Column(name = "savingMaturityYrs")
	private Integer savingMaturityYrs; // NOTNULL

	@NonNull
	@Column(name = "roi")
	private Integer roi; // NOTNULL	

	@Column(name = "createdBy")
	private String createdBy;	

	@CurrentTimestamp
	@Column(name = "createdDate")
	private LocalDateTime createdDate;	//TIMESTAMP	

	@Column(name = "modifiedBy")
	private String modifiedBy;	

	@UpdateTimestamp
	@Column(name = "modifiedDate")
	private LocalDateTime modifiedDate; //	TIMESTAMP

	@NonNull
	@Column(name = "active")
	private Boolean active;	
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
