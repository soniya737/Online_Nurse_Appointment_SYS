package com.soniyad30.online_nurse_appointment.ServiceImplement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soniyad30.online_nurse_appointment.DTO.AppointmentDTO;
import com.soniyad30.online_nurse_appointment.DTO.AppointmentViewDTO;
import com.soniyad30.online_nurse_appointment.Entity.Appointment;
import com.soniyad30.online_nurse_appointment.Entity.Customer;
import com.soniyad30.online_nurse_appointment.Entity.HealthCare;
import com.soniyad30.online_nurse_appointment.Entity.NurseEntity;
import com.soniyad30.online_nurse_appointment.Exception.ResourceNotFoundException;
import com.soniyad30.online_nurse_appointment.Mapper.AppointmentMapper;
import com.soniyad30.online_nurse_appointment.Repository.AppointmentRepository;
import com.soniyad30.online_nurse_appointment.Repository.Cust_Repository;
import com.soniyad30.online_nurse_appointment.Repository.HealthCareRepository;
import com.soniyad30.online_nurse_appointment.Repository.Nurse_Repository;
import com.soniyad30.online_nurse_appointment.Service.AppointmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    
    @Override
    public List<AppointmentViewDTO> viewAppointmentsOfCustomer(Integer customerID) {
        
        customerRepository.findById(customerID).orElseThrow(
            
            () -> new ResourceNotFoundException("customerID: " + customerID + " | Error: Customer not present in database.")
            
        );
        
        List<Appointment> appointmentList = appointmentRepository.findByCustomerCustID(customerID);
        
        if(appointmentList.isEmpty()) throw new ResourceNotFoundException("customerID: " + customerID + " | Status: Zero appointments present in database.");
        
        return appointmentList.stream().map((appointment) -> AppointmentMapper.mapToAppointmentViewDTO(appointment)).collect(Collectors.toList());
        
    }
    
    @Override
    public List<AppointmentViewDTO> viewAppointmentsOfNurse(Integer nurseID) {
        
        nurseRepository.findById(nurseID).orElseThrow(
            
            () -> new ResourceNotFoundException("nurseID: " + nurseID + " | Error: Nurse not present in database.")
            
        );
        
        List<Appointment> appointmentList = appointmentRepository.findByNurseNurseID(nurseID);
        
        if(appointmentList.isEmpty()) throw new ResourceNotFoundException("nurseID: " + nurseID + " | Status: Zero appointments present in database.");
        
        return appointmentList.stream().map((appointment) -> AppointmentMapper.mapToAppointmentViewDTO(appointment)).collect(Collectors.toList());
        
    }
    
    @Override
    public List<AppointmentViewDTO> viewAppointmentsOfHealthCare(Integer healthCareID) {
        
        healthCareRepository.findById(healthCareID).orElseThrow(
            
            () -> new ResourceNotFoundException("healthCareID: " + healthCareID + " | Error: HealthCare not present in database.")
            
        );
        
        List<Appointment> appointmentList = appointmentRepository.findByHealthCareHealthCareID(healthCareID);
        
        if(appointmentList.isEmpty()) throw new ResourceNotFoundException("healthCareID: " + healthCareID + " | Status: Zero appointments present in database.");
        
        return appointmentList.stream().map((appointment) -> AppointmentMapper.mapToAppointmentViewDTO(appointment)).collect(Collectors.toList());
        
    }
    
    @Override
    public AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO) {
        
        customerRepository.findById(appointmentDTO.getCustomerID()).orElseThrow(
            
            () -> new ResourceNotFoundException("customerID: " + appointmentDTO.getCustomerID() + " | Error: Customer not present in database.")
            
        );
        
        nurseRepository.findById(appointmentDTO.getNurseID()).orElseThrow(
            
            () -> new ResourceNotFoundException("nurseID: " + appointmentDTO.getNurseID() + " | Error: Nurse not present in database.")
            
        );
        
        healthCareRepository.findById(appointmentDTO.getHealthCareID()).orElseThrow(
            
            () -> new ResourceNotFoundException("healthCareID: " + appointmentDTO.getHealthCareID() + " | Error: HealthCare not present in database.")
            
        );
        
        Appointment appointment = AppointmentMapper.mapToAppointment(appointmentDTO.getAppointmentID(), customerRepository.findById(appointmentDTO.getCustomerID()).get(), nurseRepository.findById(appointmentDTO.getNurseID()).get(), healthCareRepository.findById(appointmentDTO.getHealthCareID()).get(), false);
        
        Appointment registeredAppointment = appointmentRepository.save(appointment);
        
        return AppointmentMapper.mapToAppointmentDTO(registeredAppointment.getAppointmentID(), registeredAppointment.getCustomer().getCustID(), registeredAppointment.getNurse().getNurseID(), registeredAppointment.getHealthCare().getHealthCareID(), registeredAppointment.getPaymentStatus());
        
    }
    
    @Override
    public AppointmentDTO updateAppointment(Integer appointmentID, AppointmentDTO appointmentDTO) {
        
        Appointment appointment = appointmentRepository.findById(appointmentID).orElseThrow(
            
            () -> new ResourceNotFoundException("appointmentID: " + appointmentID + " | Error: Appointment not present in database.")
            
        );
        
        Customer customer = customerRepository.findById(appointmentDTO.getCustomerID()).orElseThrow(
            
            () -> new ResourceNotFoundException("customerID: " + appointmentDTO.getCustomerID() + " | Error: Customer not present in database.")
            
        );
        
        NurseEntity nurse = nurseRepository.findById(appointmentDTO.getNurseID()).orElseThrow(
            
            () -> new ResourceNotFoundException("nurseID: " + appointmentDTO.getNurseID() + " | Error: Nurse not present in database.")
            
        );
        
        HealthCare healthCare = healthCareRepository.findById(appointmentDTO.getHealthCareID()).orElseThrow(
            
            () -> new ResourceNotFoundException("healthCareID: " + appointmentDTO.getHealthCareID() + " | Error: HealthCare not present in database.")
            
        );
        
        appointment.setCustomer(customer);
        appointment.setNurse(nurse);
        appointment.setHealthCare(healthCare);
        
        appointmentRepository.save(appointment);
        
        return AppointmentMapper.mapToAppointmentDTO(appointmentID, customer.getCustID(), nurse.getNurseID(), healthCare.getHealthCareID(), appointment.getPaymentStatus());
        
    }
    
    @Override
    public void deleteAppointment(Integer appointmentID) {
        
        appointmentRepository.findById(appointmentID).orElseThrow(
            
            () -> new ResourceNotFoundException("appointmentID: " + appointmentID + " | Error: Appointment not present in database.")
            
        );
        
        appointmentRepository.deleteById(appointmentID);
        
    }
    
    @Override
    public void payForAppointment(Integer appointmentID) {
        
        Appointment appointment = appointmentRepository.findById(appointmentID).orElseThrow(
            
            () -> new ResourceNotFoundException("appointmentID: " + appointmentID + " | Error: Appointment not present in database.")
            
        );
        
        appointment.setPaymentStatus(true);
        
        appointmentRepository.save(appointment);
        
    }
    
    private
        
        AppointmentRepository appointmentRepository;
        Cust_Repository customerRepository;
        Nurse_Repository nurseRepository;
        HealthCareRepository healthCareRepository;
        
}