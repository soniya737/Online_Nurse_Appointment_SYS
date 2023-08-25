package com.soniyad30.online_nurse_appointment.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soniyad30.online_nurse_appointment.DTO.Cust_DTO;
import com.soniyad30.online_nurse_appointment.Service.Cust_Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api/Customer")
public class Cust_Controller {
    
    @PostMapping("/add")
    public ResponseEntity<Cust_DTO> addCustomer(@RequestBody Cust_DTO customerDTO) {
        
        Cust_DTO customer = cust_Service.addCustomer(customerDTO);
        
        return new ResponseEntity<Cust_DTO>(customer, HttpStatus.CREATED);
        
    }
    
    @PutMapping("{Cust_ID}")
    public ResponseEntity<Cust_DTO> updateCustomer(@PathVariable("Cust_ID") Integer Cust_ID, @RequestBody Cust_DTO customerDTO) {
        
        Cust_DTO customer = cust_Service.updateCustomer(Cust_ID, customerDTO);
        
        return ResponseEntity.ok(customer);
        
    }
    
    @DeleteMapping("{Cust_ID}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("Cust_ID") Integer Cust_ID) {
        
        cust_Service.deleteCustomer(Cust_ID);
        
        return ResponseEntity.ok("Status: Customer successfully deleted from database.");
        
    }
    
    private Cust_Service cust_Service;

    
}