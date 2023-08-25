package com.soniyad30.online_nurse_appointment.Mapper;

import com.soniyad30.online_nurse_appointment.DTO.AppointmentDTO;
import com.soniyad30.online_nurse_appointment.DTO.AppointmentViewDTO;
import com.soniyad30.online_nurse_appointment.Entity.Appointment;
import com.soniyad30.online_nurse_appointment.Entity.Customer;
import com.soniyad30.online_nurse_appointment.Entity.HealthCare;
import com.soniyad30.online_nurse_appointment.Entity.NurseEntity;

public class AppointmentMapper {
    
    public static Appointment mapToAppointment(Integer appointmentID, Customer customer, NurseEntity nurse, HealthCare healthCare, Boolean paymentStatus) {
        
        return new Appointment(appointmentID, customer, nurse, healthCare, paymentStatus);
        
    }
    
    public static AppointmentDTO mapToAppointmentDTO(Integer appointmentID, Integer customerID, Integer nurseID, Integer healthCareID, Boolean paymentStatus) {
        
        return new AppointmentDTO(appointmentID, customerID, nurseID, healthCareID, paymentStatus);
        
    }
    
    public static AppointmentViewDTO mapToAppointmentViewDTO(Appointment appointment) {
        
        return new AppointmentViewDTO(appointment.getAppointmentID(), Cust_Mapper.mapToCustomerDTO(appointment.getCustomer()), Nurse_Mapper.mapToNurseDTO(appointment.getNurse()), HealthCareMapper.mapToHealthCareDTO(appointment.getHealthCare()), appointment.getPaymentStatus());
        
    }
    
}