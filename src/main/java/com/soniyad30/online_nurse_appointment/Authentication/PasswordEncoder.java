package com.soniyad30.online_nurse_appointment.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    
    public static String encodePassword(String password) {
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        return passwordEncoder.encode(password);
        
    }
    
}