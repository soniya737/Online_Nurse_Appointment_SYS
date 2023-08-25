package com.soniyad30.online_nurse_appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniyad30.online_nurse_appointment.Entity.HealthCare;

public interface HealthCareRepository extends JpaRepository<HealthCare, Integer> {}