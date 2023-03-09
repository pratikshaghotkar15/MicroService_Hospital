package com.patient.service.controllers;

import com.patient.service.entities.Patient;
import com.patient.service.services.PatientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    private Logger logger= LoggerFactory.getLogger(PatientController.class);

    @PostMapping("/")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.create(patient));

    }

    int retryCount=1;
    @GetMapping("/{patientId}")
    //@CircuitBreaker(name = "BillingBreaker",fallbackMethod = "billingFallback")
    //@Retry(name = "BillingService",fallbackMethod = "billingFallback")
    @RateLimiter(name = "patientRateLimiter",fallbackMethod = "billingFallback")
    public ResponseEntity<Patient> getPatient(@PathVariable("patientId") String patientId){
        logger.info("retry count : {}", retryCount);
        retryCount++;
        return ResponseEntity.status(HttpStatus.OK).body(patientService.get(patientId));

    }


    public ResponseEntity<Patient> billingFallback(String patientId,Exception exception){
        //logger.info("Fallback is executed because service is down :",exception.getMessage());

        Patient patient=Patient.builder()
                .patientName("dummy@gmail.com")
                .disease("dummy")
                .status("dummy status")
                .patientId("789086").build();
        return new ResponseEntity<>(patient,HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<Patient>> getAll(){
        return ResponseEntity.ok(patientService.getAll());

    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> update(@PathVariable("patientId") String patientId,@RequestBody  Patient patient){
        return ResponseEntity.ok(patientService.update(patientId,patient));
    }


    @DeleteMapping("/{patientId}")
    public void delete(@PathVariable("patientId") String patientId){

        patientService.delete(patientId);
    }

    //patients by doctor id

    @GetMapping("/byDoctorId/{doctorId}")
    public ResponseEntity<List<Patient>> getList(@PathVariable("doctorId") String doctorId){
        return ResponseEntity.ok(patientService.findPatientBydoctorId(doctorId));

    }



}
