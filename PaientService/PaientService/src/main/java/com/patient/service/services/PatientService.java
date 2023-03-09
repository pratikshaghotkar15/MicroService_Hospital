package com.patient.service.services;

import com.patient.service.entities.Patient;

import java.util.List;

public interface PatientService {

    //create
    Patient create(Patient patient);

    //get all
    List<Patient> getAll();

    //get
    Patient get(String id);

    //update
    Patient update(String id,Patient patient);

    //delete
    void delete(String id);

    List<Patient> findPatientBydoctorId(String doctorId);









}
