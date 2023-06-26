package com.example.plan.entity;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "T_Customer")
public class TCustomer {
 

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    @CreatedDate
    private Instant createdDate;
 

    @Column(name = "modifiedBy")
    private String modifiedBy;

    @Column(name = "modifiedDate")
    @LastModifiedDate
    private Instant modifiedDate;

    @Column(name="active")
    boolean active;
    

 

}