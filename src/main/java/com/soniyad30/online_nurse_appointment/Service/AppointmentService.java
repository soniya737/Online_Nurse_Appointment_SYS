package com.soniyad30.online_nurse_appointment.Service;

import java.util.List;

import com.soniyad30.online_nurse_appointment.DTO.AppointmentDTO;
import com.soniyad30.online_nurse_appointment.DTO.AppointmentViewDTO;

public interface AppointmentService {
    
    List<AppointmentViewDTO> viewAppointmentsOfCustomer(Integer customerID);
    
    List<AppointmentViewDTO> viewAppointmentsOfNurse(Integer nurseID);
    
    List<AppointmentViewDTO> viewAppointmentsOfHealthCare(Integer healthCareID);
    
    AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO);
    
    AppointmentDTO updateAppointment(Integer appointmentID, AppointmentDTO appointmentDTO);
    
    void deleteAppointment(Integer appointmentID);
    
    void payForAppointment(Integer appointmentID);
    
}