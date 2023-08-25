package com.soniyad30.online_nurse_appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniyad30.online_nurse_appointment.Entity.Credential;

public interface CredentialRepository extends JpaRepository<Credential, String> {
    
    Credential findByEntityUsername(String entityUsername);
    
}