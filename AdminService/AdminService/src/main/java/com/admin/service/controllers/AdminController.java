package com.admin.service.controllers;

import com.admin.service.entities.Admin;
import com.admin.service.entities.Doctor;
import com.admin.service.entities.Patient;
import com.admin.service.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //create
    @PostMapping("/")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        Admin admin1=adminService.saveAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin1);

    }

    //single admin get
    @GetMapping("/{adminId}")
    public ResponseEntity<Admin> getSingleAdmin(@PathVariable("adminId") String adminId){
        Admin admin=adminService.getAdmin(adminId);
        return ResponseEntity.ok(admin);
    }

    //all admin get
    @GetMapping("/")
    public ResponseEntity<List<Admin>> getAllAdmins(){
        List<Admin> list=adminService.getAllAdmin();
        return  ResponseEntity.ok(list);
    }

    //update admin
    @PutMapping("/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") String adminId,@RequestBody Admin admin){
        Admin admin1=adminService.updateAdmin(adminId,admin);
        return ResponseEntity.ok(admin1);

    }
    //delete admin

    @DeleteMapping("/{adminId}")
    public void deleteAdmin(@PathVariable("adminId") String adminId){
        adminService.deleteAdmin(adminId);
    }


    //get all patients
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(adminService.getAllPatients());
    }

    //get all doctors
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(adminService.getAllDoctors());
    }

    //get patient by calling patient service
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable("patientId") String patientId ){
        return ResponseEntity.ok(adminService.getPatient(patientId));


    }

    //get doctor by calling doctor service

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable("doctorId") String doctorId){
        return ResponseEntity.ok(adminService.getDoctor(doctorId));


    }


}
