package com.patient.service.repositories;

import com.patient.service.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient,String> {

    List<Patient> findPatientByDoctorId(String doctorId);
}
