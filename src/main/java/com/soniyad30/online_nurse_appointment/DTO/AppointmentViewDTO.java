package com.soniyad30.online_nurse_appointment.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentViewDTO {
    
    private
        
        Integer appointmentID;
        Cust_DTO customerDTO;
        Nurse_DTO nurseDTO;
        HealthCareDTO healthCareDTO;
        Boolean paymentStatus;
        
}