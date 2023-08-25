package com.soniyad30.online_nurse_appointment.Mapper;

import com.soniyad30.online_nurse_appointment.DTO.Nurse_DTO;
import com.soniyad30.online_nurse_appointment.Entity.NurseEntity;

public class Nurse_Mapper {
      
    public static NurseEntity mapToNurse(Nurse_DTO nurseDTO) {
        
        return new NurseEntity(nurseDTO.getNurse_ID(), nurseDTO.getNurse_Name(), nurseDTO.getNurse_Address(), nurseDTO.getNurse_ContactNo());
        
    }
    
    public static Nurse_DTO mapToNurseDTO(NurseEntity nurse) {
        
        return new Nurse_DTO(nurse.getNurseID(), nurse.getNurseName(), nurse.getNurseAddress(), nurse.getNurseContactNo());   
        
    }
    
}
