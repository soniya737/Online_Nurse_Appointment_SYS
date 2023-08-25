package com.soniyad30.online_nurse_appointment.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soniyad30.online_nurse_appointment.Entity.NurseEntity;
@SpringBootTest
public class NurserepositoryTest {
    @Test

    void NurseRepositorySaveReturnSavesNurse()
    {
        NurseEntity nurse =NurseEntity.builder().nurseName("").nurseAddress("").nurseContactNo("").build();

        NurseEntity savedNurse = nurse_Repository.save(nurse);

        Assertions.assertThat(savedNurse).isNotNull();

    }

    @Test
    void NurseRepositorySaveIncrementNurseID()
    {
        NurseEntity nurse =NurseEntity.builder().nurseName("").nurseAddress("").nurseContactNo("").build();

        NurseEntity savedNurse = nurse_Repository.save(nurse);

        Assertions.assertThat(savedNurse.getNurseID()).isGreaterThan(0);

    }

    @Autowired
    private Nurse_Repository nurse_Repository;
}
