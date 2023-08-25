package com.soniyad30.online_nurse_appointment.ServiceImplement;

import org.springframework.stereotype.Service;

import com.soniyad30.online_nurse_appointment.DTO.Cust_DTO;
import com.soniyad30.online_nurse_appointment.Entity.Customer;
import com.soniyad30.online_nurse_appointment.Exception.ResourceNotFoundException;
import com.soniyad30.online_nurse_appointment.Mapper.Cust_Mapper;
import com.soniyad30.online_nurse_appointment.Repository.Cust_Repository;
import com.soniyad30.online_nurse_appointment.Service.Cust_Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class Cust_Service_Impl implements Cust_Service {
    @Override
    public Cust_DTO addCustomer(Cust_DTO customerDTO) {
        
        Customer customer = Cust_Mapper.mapToCustomer(customerDTO);
        
        Customer addedCustomer = Cust_Repository.save(customer);
        
        return Cust_Mapper.mapToCustomerDTO(addedCustomer);
        
    }
    
    @Override
    public Cust_DTO updateCustomer(Integer Cust_ID, Cust_DTO customerDTO) {
        
        Customer customer = Cust_Repository.findById(Cust_ID).orElseThrow(
            
            () -> new ResourceNotFoundException("customerID: " + Cust_ID + " | Status: Customer not present in database.")
            
        );
        
        customer.setCustName(customerDTO.getCustName());
        customer.setCustAddress(customerDTO.getCustAddress());
        customer.setCustContactNo(customerDTO.getCustContactNo());
        
        Customer updatedCustomer = Cust_Repository.save(customer);
        
        return Cust_Mapper.mapToCustomerDTO(updatedCustomer);
        
    }
    
    @Override
    public void deleteCustomer(Integer Cust_ID) {
        
        Cust_Repository.findById(Cust_ID).orElseThrow(
            
            () -> new ResourceNotFoundException("customerID: " + Cust_ID + " | Status: Customer not present in database.")
            
        );
        
        Cust_Repository.deleteById(Cust_ID);
        
    }
    
    private Cust_Repository Cust_Repository;
    
}