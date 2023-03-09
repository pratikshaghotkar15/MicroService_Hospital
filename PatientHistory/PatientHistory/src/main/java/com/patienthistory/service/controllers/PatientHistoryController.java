package com.patienthistory.service.controllers;

import com.patienthistory.service.entities.PatientHistory;
import com.patienthistory.service.repositories.PatienthistoryRepository;
import com.patienthistory.service.services.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patienthistory")
public class PatientHistoryController {

    @Autowired
    private PatientHistoryService patientHistoryService;


    @PostMapping("/")
    public ResponseEntity<PatientHistory> createPatientHistory(@RequestBody PatientHistory patientHistory){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientHistoryService.create(patientHistory));

    }

    @GetMapping("/{patienthistoryId}")
    public ResponseEntity<PatientHistory> getPatient(@PathVariable("patienthistoryId") String patienthistoryId){
        return ResponseEntity.status(HttpStatus.OK).body(patientHistoryService.get(patienthistoryId));

    }

    @GetMapping("/")
    public ResponseEntity<List<PatientHistory>> getAll(){
        return ResponseEntity.ok(patientHistoryService.getall());

    }

    @PutMapping("/{patienthistoryId}")
    public ResponseEntity<PatientHistory> update(@PathVariable("patienthistoryId") String patienthistoryId,@RequestBody PatientHistory patientHistory){
        return ResponseEntity.ok(patientHistoryService.update(patienthistoryId,patientHistory));
    }


    @DeleteMapping("/{patienthistoryId}")
    public void delete(@PathVariable("patienthistoryId") String patienthistoryId){

        patientHistoryService.delete(patienthistoryId);
    }


}
