package com.example.plan.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.example.plan.enums.PlanTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_LI_PLANTYPE")
public class PlanType {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer planTypeId;
	
	
	@Column(name = "planCode",unique = true)
	private int planCode;
	
	@Column(name = "planName",unique = true)
	@Enumerated(EnumType.STRING)
	private PlanTypeEnum planName;
	
	@Column(name = "createdBy")
	private String createdBy;
	
	@CurrentTimestamp
	@Column(name = "createdDate")
	private LocalDateTime createdDate;
	
	@Column(name = "modifiedBy")
	private String modifiedBy;
	
	@UpdateTimestamp
	@Column(name = "modifiedDate")
	private LocalDateTime modifiedDate;
	
	@Column(name = "active")
	private boolean active;
}
