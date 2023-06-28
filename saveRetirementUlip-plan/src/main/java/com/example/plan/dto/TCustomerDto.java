package com.example.plan.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TCustomerDto {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String createdBy;
    private LocalDateTime createdDate;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    boolean active;
    

 

}
