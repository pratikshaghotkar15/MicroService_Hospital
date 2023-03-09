package com.doctor.service.service;

import com.doctor.service.entities.Doctor;

import java.util.List;

public interface DoctorService {

    //create
    Doctor create(Doctor doctor);

    //get all
    List<Doctor> getAll();

    //get single by id
    Doctor get(String id);

    //update
    Doctor update(String id,Doctor doctor);

    //delete
    void delete(String id);
}
