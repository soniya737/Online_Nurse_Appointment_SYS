package com.soniyad30.online_nurse_appointment.Mapper;

import com.soniyad30.online_nurse_appointment.DTO.AdminDTO;
import com.soniyad30.online_nurse_appointment.Entity.Credential;

public class AdminMapper {
    
    public static Credential mapToCredential(AdminDTO adminDTO) {
        
        return new Credential(adminDTO.getAdminUsername(), adminDTO.getAdminPassword(), "ADMIN");
        
    }
    
    public static AdminDTO mapToAdminDTO(Credential credential) {
        
        return new AdminDTO(credential.getEntityUsername(), credential.getEntityPassword());
        
    }
    
}