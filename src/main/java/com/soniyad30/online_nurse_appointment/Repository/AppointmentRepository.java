package com.soniyad30.online_nurse_appointment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniyad30.online_nurse_appointment.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    
    List<Appointment> findByCustomerCustID(Integer customerID);
    
    List<Appointment> findByNurseNurseID(Integer nurseID);
    
    List<Appointment> findByHealthCareHealthCareID(Integer healthCareID);
    
    void deleteAllByCustomerCustID(Integer customerID);
    
    void deleteAllByHealthCareHealthCareID(Integer healthCareID);
    
}