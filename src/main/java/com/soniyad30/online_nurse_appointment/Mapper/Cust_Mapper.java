package com.soniyad30.online_nurse_appointment.Mapper;

import com.soniyad30.online_nurse_appointment.DTO.Cust_DTO;
import com.soniyad30.online_nurse_appointment.Entity.Customer;

public class Cust_Mapper {
    
    public static Customer mapToCustomer(Cust_DTO customerDTO) {
        
        return new Customer(customerDTO.getCustID(), customerDTO.getCustName(), customerDTO.getCustAddress(), customerDTO.getCustContactNo());
        
    }
    
    public static Cust_DTO mapToCustomerDTO(Customer customer) {
        
        return new Cust_DTO(customer.getCustID(), customer.getCustName(), customer.getCustAddress(), customer.getCustContactNo());
        
    }
    
}
