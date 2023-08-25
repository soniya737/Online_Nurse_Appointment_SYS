package com.soniyad30.online_nurse_appointment.Mapper;

import com.soniyad30.online_nurse_appointment.DTO.HealthCareDTO;
import com.soniyad30.online_nurse_appointment.Entity.HealthCare;

public class HealthCareMapper {
    
    public static HealthCare mapToHealthCare(HealthCareDTO healthCareDTO) {
        
        return new HealthCare(healthCareDTO.getHealthCareID(), healthCareDTO.getHealthCareDescription(), healthCareDTO.getHealthCareCharge());
        
    }
    
    public static HealthCareDTO mapToHealthCareDTO(HealthCare healthCare) {
        
        return new HealthCareDTO(healthCare.getHealthCareID(), healthCare.getHealthCareDescription(), healthCare.getHealthCareCharge());
        
    }
    
}