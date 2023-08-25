package com.soniyad30.online_nurse_appointment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class DuplicateResourceFoundException extends RuntimeException {
    
    public DuplicateResourceFoundException(String message) {
        
        super(message);
        
    }
    
}