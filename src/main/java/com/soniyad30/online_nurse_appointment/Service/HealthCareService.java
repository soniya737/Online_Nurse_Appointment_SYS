package com.soniyad30.online_nurse_appointment.Service;

import com.soniyad30.online_nurse_appointment.DTO.HealthCareDTO;

public interface HealthCareService {
    
    HealthCareDTO registerHealthCare(HealthCareDTO healthCareDTO);
    
    HealthCareDTO updateHealthCare(Integer healthCareID, HealthCareDTO healthCareDTO);
    
    void deleteHealthCare(Integer healthCareID);
    
}