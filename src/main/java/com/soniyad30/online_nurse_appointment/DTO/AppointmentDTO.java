package com.soniyad30.online_nurse_appointment.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentDTO {
    
    private
        
        Integer appointmentID, customerID, nurseID, healthCareID;
        Boolean paymentStatus;
        
}