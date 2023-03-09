package com.admin.service.services;

import com.admin.service.entities.Admin;
import com.admin.service.entities.Doctor;
import com.admin.service.entities.Patient;
import com.admin.service.exceptions.ResourceNotFoundException;
import com.admin.service.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
 class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Admin saveAdmin(Admin admin) {
        String randomId=UUID.randomUUID().toString();
        admin.setAdminId(randomId);
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdmin(String adminId) {
        return adminRepository.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("admin with given id is not found"+adminId));
    }

    @Override
    public Admin updateAdmin(String adminId,Admin admin) {
        admin.setAdminId(adminId);
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(String adminId) {
        adminRepository.deleteById(adminId);

    }

    @Override
    public List<Patient> getAllPatients() {
        ArrayList<Patient> listOfPatients=restTemplate.getForObject("http://localhost:8083/patients/", ArrayList.class);
        return listOfPatients;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        ArrayList<Doctor> listOfDoctors=restTemplate.getForObject("http://localhost:8082/doctors/", ArrayList.class);
        return listOfDoctors;
    }

    @Override
    public Patient getPatient(String id) {
        Patient patient=restTemplate.getForObject("http://localhost:8083/patients/"+id, Patient.class);
        return patient;
    }

    @Override
    public Doctor getDoctor(String id) {
        Doctor doctor=restTemplate.getForObject("http://localhost:8082/doctors/"+id, Doctor.class);
        return doctor;
    }


}
