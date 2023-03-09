package com.admin.service.services;

import com.admin.service.entities.Admin;
import com.admin.service.entities.Doctor;
import com.admin.service.entities.Patient;

import java.util.List;

public interface AdminService {

    //admin operations


    //create
    Admin saveAdmin(Admin admin);


    //get all admin
    List<Admin> getAllAdmin();


    //get single admin
    Admin getAdmin(String adminId);

    //update Admin
    Admin updateAdmin(String adminId,Admin admin);

    //delete admin

     void deleteAdmin(String adminId);

     List<Patient> getAllPatients();
     List<Doctor> getAllDoctors();

    Patient getPatient(String id);

    //get Doctor
    Doctor getDoctor(String id);





}
