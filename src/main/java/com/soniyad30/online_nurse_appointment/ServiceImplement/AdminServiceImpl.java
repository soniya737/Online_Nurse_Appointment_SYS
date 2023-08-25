package com.soniyad30.online_nurse_appointment.ServiceImplement;
import org.springframework.stereotype.Service;

import com.soniyad30.online_nurse_appointment.Authentication.PasswordEncoder;
import com.soniyad30.online_nurse_appointment.DTO.AdminDTO;
import com.soniyad30.online_nurse_appointment.Entity.Credential;
import com.soniyad30.online_nurse_appointment.Exception.DuplicateResourceFoundException;
import com.soniyad30.online_nurse_appointment.Exception.ResourceNotFoundException;
import com.soniyad30.online_nurse_appointment.Mapper.AdminMapper;
import com.soniyad30.online_nurse_appointment.Repository.CredentialRepository;
import com.soniyad30.online_nurse_appointment.Service.AdminService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    
    @Override
    public AdminDTO registerAdmin(AdminDTO adminDTO) {
        
        Credential credential = AdminMapper.mapToCredential(adminDTO);
        
        if(credentialRepository.existsById(credential.getEntityUsername())) throw new DuplicateResourceFoundException("adminUsername: " + credential.getEntityUsername() + " | Status: Username already present in database.");
        
        String adminPassword = credential.getEntityPassword();
        
        credential.setEntityPassword(PasswordEncoder.encodePassword(adminPassword));
        
        Credential registeredCredential = credentialRepository.save(credential);
        
        registeredCredential.setEntityPassword(adminPassword);
        
        return AdminMapper.mapToAdminDTO(registeredCredential);
        
    }
    
    @Override
    public void deleteAdmin(String adminUsername) {
        
        if(!(credentialRepository.existsById(adminUsername) && credentialRepository.findById(adminUsername).get().getEntityRole().equals("ADMIN"))) throw new ResourceNotFoundException("adminUsername: " + adminUsername + " | Status: Admin not present in database.");
        
        credentialRepository.deleteById(adminUsername);
        
    }
    
    private CredentialRepository credentialRepository;
    
}