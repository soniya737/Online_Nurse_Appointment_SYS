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
@Table(name = ("NurseTable"))

public class NurseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nurseID")
    private Integer nurseID;
    
    @Column(name = "nurseName")
    private String nurseName;
    
    @Column(name = "nurseAddress")
    private String nurseAddress;
    
    @Column(name = "nurseContactNo")
    private String nurseContactNo;

}

