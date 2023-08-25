package com.soniyad30.online_nurse_appointment.ServiceImplement;

import org.springframework.stereotype.Service;

import com.soniyad30.online_nurse_appointment.DTO.HealthCareDTO;
import com.soniyad30.online_nurse_appointment.Entity.HealthCare;
import com.soniyad30.online_nurse_appointment.Exception.ResourceNotFoundException;
import com.soniyad30.online_nurse_appointment.Mapper.HealthCareMapper;
import com.soniyad30.online_nurse_appointment.Repository.HealthCareRepository;
import com.soniyad30.online_nurse_appointment.Service.HealthCareService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HealthCareServiceImpl implements HealthCareService {
    
    @Override
    public HealthCareDTO registerHealthCare(HealthCareDTO healthCareDTO) {
        
        HealthCare healthCare = HealthCareMapper.mapToHealthCare(healthCareDTO);
        
        HealthCare registeredHealthCare = healthCareRepository.save(healthCare);
        
        return HealthCareMapper.mapToHealthCareDTO(registeredHealthCare);
        
    }
    
    @Override
    public HealthCareDTO updateHealthCare(Integer healthCareID, HealthCareDTO healthCareDTO) {
        
        HealthCare healthCare = healthCareRepository.findById(healthCareID).orElseThrow(
            
            () -> new ResourceNotFoundException("healthCareID: " + healthCareID + " | Status: HealthCare not present in database.")
            
        );
        
        healthCare.setHealthCareDescription(healthCareDTO.getHealthCareDescription());
        healthCare.setHealthCareCharge(healthCareDTO.getHealthCareCharge());
        
        HealthCare updatedHealthCare = healthCareRepository.save(healthCare);
        
        return HealthCareMapper.mapToHealthCareDTO(updatedHealthCare);
        
    }
    
    @Override
    public void deleteHealthCare(Integer healthCareID) {
        
        healthCareRepository.findById(healthCareID).orElseThrow(
            
            () -> new ResourceNotFoundException("healthCareID: " + healthCareID + " | Status: HealthCare not present in database.")
            
        );
        
        healthCareRepository.deleteById(healthCareID);
        
    }
    
    private HealthCareRepository healthCareRepository;
    
}