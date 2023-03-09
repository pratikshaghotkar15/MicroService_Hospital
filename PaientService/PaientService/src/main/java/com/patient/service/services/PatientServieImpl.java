package com.patient.service.services;
import com.patient.service.entities.Billing;
import com.patient.service.entities.Patient;
import com.patient.service.exceptions.ResourceNotFoundException;
import com.patient.service.repositories.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;


@Service
public class PatientServieImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(PatientService.class);
    @Override
    public Patient create(Patient patient) {
        //String s=UUID.randomUUID().toString();
        //patient.setPatientId(s);

        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient get(String id) {
        Patient patient=patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found"));

        //fetch billing status from billing microservice
        //http://localhost:8086/billings/patient/63f605a2e95bd940e5ba2193
        Billing billing1=restTemplate.getForObject("http://localhost:8086/billings/patient/"+patient.getPatientId(), Billing.class);
        logger.info("{} ",billing1);
        patient.setBillingStatus(billing1);
        return patient;
    }

    @Override
    public Patient update(String id,Patient patient) {
        patient.setPatientId(id);
        Patient patient1=patientRepository.save(patient);
        return patient1;
    }

    @Override
    public void delete(String id) {
        patientRepository.deleteById(id);

    }

    @Override
    public List<Patient> findPatientBydoctorId(String doctorId) {
        return patientRepository.findPatientByDoctorId(doctorId);
    }
}
