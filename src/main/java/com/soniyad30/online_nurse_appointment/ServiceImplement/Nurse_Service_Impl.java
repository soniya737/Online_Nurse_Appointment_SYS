package com.soniyad30.online_nurse_appointment.ServiceImplement;

import org.springframework.stereotype.Service;

import com.soniyad30.online_nurse_appointment.DTO.Nurse_DTO;
import com.soniyad30.online_nurse_appointment.Entity.NurseEntity;
import com.soniyad30.online_nurse_appointment.Exception.ResourceNotFoundException;
import com.soniyad30.online_nurse_appointment.Mapper.Nurse_Mapper;
import com.soniyad30.online_nurse_appointment.Repository.Nurse_Repository;
import com.soniyad30.online_nurse_appointment.Service.Nurse_Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class Nurse_Service_Impl  implements Nurse_Service {
    @Override
    public Nurse_DTO addNurse(Nurse_DTO nurseDTO) {
        
        NurseEntity nurse = Nurse_Mapper.mapToNurse(nurseDTO);
        
        NurseEntity addedNurse = Nurse_Repository.save(nurse);
        
        return Nurse_Mapper.mapToNurseDTO(addedNurse);
        
    }
    
    @Override
    public Nurse_DTO updateNurse(Integer nurse_ID, Nurse_DTO nurseDTO) {
        
        NurseEntity nurse = Nurse_Repository.findById(nurse_ID).orElseThrow(
            
            () -> new ResourceNotFoundException("customerID: " + nurse_ID + " | Status: Nurse not present in database.")
            
        );
        
        nurse.setNurseName(nurseDTO.getNurse_Name());
        nurse.setNurseAddress(nurseDTO.getNurse_Address());
        nurse.setNurseContactNo(nurseDTO.getNurse_ContactNo());
        
        NurseEntity updatedNurse = Nurse_Repository.save(nurse);
        
        return Nurse_Mapper.mapToNurseDTO(updatedNurse);
        
    }
    
    private String nurseTOOgetCNurseAddress() {
        return null;
    }

    @Override
    public void deleteNurse(Integer nurse_ID) {
        
        Nurse_Repository.findById(nurse_ID).orElseThrow(
            
            () -> new ResourceNotFoundException("nurseID: " + nurse_ID + " | Status: Nurse not present in database.")
            
        );
        
        Nurse_Repository.deleteById(nurse_ID);
        
    }
    
    private Nurse_Repository Nurse_Repository;

    
}