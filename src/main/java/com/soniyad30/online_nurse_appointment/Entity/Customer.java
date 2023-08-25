package com.soniyad30.online_nurse_appointment.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = ("CustomerTable"))
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custID")
    private Integer custID;
    
    @Column(name = "custName")
    private String custName;
    
    @Column(name = "custAddress")
    private String custAddress;
    
    @Column(name = "custContactNo")
    private String custContactNo;
}
