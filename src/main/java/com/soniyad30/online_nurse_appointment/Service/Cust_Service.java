package com.soniyad30.online_nurse_appointment.Service;

import com.soniyad30.online_nurse_appointment.DTO.Cust_DTO;

public interface Cust_Service {
    
    Cust_DTO addCustomer(Cust_DTO customerDTO);
    
    Cust_DTO updateCustomer(Integer Cust_ID, Cust_DTO customerDTO);
    
    void deleteCustomer(Integer Cust_ID);

    
}