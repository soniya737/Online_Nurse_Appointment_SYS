package com.soniyad30.online_nurse_appointment.Service;

import com.soniyad30.online_nurse_appointment.DTO.Nurse_DTO;

public interface Nurse_Service {

    Nurse_DTO addNurse(Nurse_DTO nurseDTO);

    Nurse_DTO updateNurse(Integer nurse_ID, Nurse_DTO nurseDTO);
    
    void deleteNurse(Integer nurse_ID);
}
