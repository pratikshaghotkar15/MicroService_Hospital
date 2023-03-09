package com.doctor.service.externalservices;

import com.doctor.service.entities.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientService {

    //post
    @PostMapping("/patients/")
    public Patient createPatient(Patient value);


    //put
    @PutMapping("/patients/{patientId}")
    public Patient updatePatient(@PathVariable("patientId") String patientId, Patient patient);


    //delete
    @DeleteMapping("/patients/{patientId}")
    public void deletePatient(@PathVariable("patientId") String patientId);
}
