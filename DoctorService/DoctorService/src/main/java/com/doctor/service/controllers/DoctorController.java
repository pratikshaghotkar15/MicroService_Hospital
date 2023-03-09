package com.doctor.service.controllers;

import com.doctor.service.entities.Doctor;
import com.doctor.service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.create(doctor));

    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable("doctorId") String doctorId){
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.get(doctorId));

    }

    @GetMapping("/")
    public ResponseEntity<List<Doctor>> getAll(){
        return ResponseEntity.ok(doctorService.getAll());

    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<Doctor> update(@PathVariable("doctorId") String doctorId,@RequestBody  Doctor doctor){
        return ResponseEntity.ok(doctorService.update(doctorId,doctor));
    }


    @DeleteMapping("/{doctorId}")
    public void delete(@PathVariable("doctorId") String id){
        doctorService.delete(id);
    }

}
