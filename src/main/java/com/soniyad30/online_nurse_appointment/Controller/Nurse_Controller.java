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

import com.soniyad30.online_nurse_appointment.DTO.Nurse_DTO;
import com.soniyad30.online_nurse_appointment.Service.Nurse_Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api/Nurse")
public class Nurse_Controller {
    
    @PostMapping
    public ResponseEntity<Nurse_DTO> addNurse(@RequestBody Nurse_DTO nurseDTO) {
        
        Nurse_DTO nurse = ((com.soniyad30.online_nurse_appointment.Service.Nurse_Service) Nurse_Service).addNurse(nurseDTO);
        
        return new ResponseEntity<Nurse_DTO>(nurse, HttpStatus.CREATED);
        
    }
    
    @PutMapping("{nurse_ID}")
    public ResponseEntity<Nurse_DTO> updateNurse(@PathVariable("nurse_ID") Integer nurse_ID, @RequestBody Nurse_DTO NurseDTO) {
        
        Nurse_DTO nurse = ((com.soniyad30.online_nurse_appointment.Service.Nurse_Service) Nurse_Service).updateNurse(nurse_ID, NurseDTO);
        
        return ResponseEntity.ok(nurse);
        
    }
    
    @DeleteMapping("{nurse_ID}")
    public ResponseEntity<String> deleteNurse(@PathVariable("nurse_ID") Integer nurse_ID) {
        
        ((com.soniyad30.online_nurse_appointment.Service.Cust_Service) Nurse_Service).deleteCustomer(nurse_ID);
        
        return ResponseEntity.ok("Status: Nurse successfully deleted from database.");
        
    }
    
    private Nurse_Service Nurse_Service;
}
