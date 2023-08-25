package com.soniyad30.online_nurse_appointment.Service;

import com.soniyad30.online_nurse_appointment.DTO.AdminDTO;

public interface AdminService {
    
    AdminDTO registerAdmin(AdminDTO adminDTO);
    
    void deleteAdmin(String adminUsername);
    
}