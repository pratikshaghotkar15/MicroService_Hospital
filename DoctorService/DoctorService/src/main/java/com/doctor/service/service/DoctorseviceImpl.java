package com.doctor.service.service;

import com.doctor.service.entities.Doctor;
import com.doctor.service.entities.Patient;
import com.doctor.service.entities.PatientHistory;
import com.doctor.service.exceptions.ResourceNotFoundException;
import com.doctor.service.externalservices.PatientHistoryService;
import com.doctor.service.repositores.DoctorRepository;
import com.fasterxml.classmate.members.ResolvedParameterizedMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorseviceImpl implements DoctorService{
    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(DoctorseviceImpl.class);

    //feign client
    @Autowired
    private PatientHistoryService patientHistoryService;

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor create(Doctor doctor) {
        String doctorid= UUID.randomUUID().toString();
        doctor.setDoctorId(doctorid);
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor get(String id) {
         Doctor doctor= doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("doctor doesnt exist with this id"+id));



       // ArrayList<Patient> allpatientshandlebydoctor=restTemplate.getForObject("http://localhost:8083/patients/byDoctorId/"+doctor.getDoctorId(), ArrayList.class);

        Patient[] allpatientshandlebydoctor=restTemplate.getForObject("http://PATIENT-SERVICE/patients/byDoctorId/"+doctor.getDoctorId(), Patient[].class);
        logger.info("{} ",allpatientshandlebydoctor);

        List<Patient> allPatientsOfdoctor=Arrays.stream(allpatientshandlebydoctor).toList();


       List<Patient> updatedPatientsList=allPatientsOfdoctor.stream().map(patient -> {
            //api call to patienthistory to get patienthistory
            //http://localhost:8087/patienthistory/ef6e6d33-c945-43c7-b963-900188e51d50

          // ResponseEntity<PatientHistory> forentity=restTemplate.getForEntity("http://PATIENTHISTORY-SERVICE/patienthistory/"+patient.getPatientHistoryId(), PatientHistory.class);

          // PatientHistory patientHistory=forentity.getBody();
           PatientHistory patientHistory=patientHistoryService.getPatientHistory(patient.getPatientHistoryId());
           //logger.info("response status code: {} ",forentity.getStatusCode());

            //set the patienthistory
           patient.setPatientHistory(patientHistory);
            //return patient
           return patient;

        }).collect(Collectors.toList());

       // doctor.setListOfPatients(allpatientshandlebydoctor);
        doctor.setListOfPatients(updatedPatientsList);
        return doctor;




    }

    @Override
    public Doctor update(String id,Doctor doctor) {
        doctor.setDoctorId(id);
        Doctor doctor1=doctorRepository.save(doctor);
        return doctor1;
    }

    @Override
    public void delete(String id) {
        doctorRepository.deleteById(id);

    }
}
