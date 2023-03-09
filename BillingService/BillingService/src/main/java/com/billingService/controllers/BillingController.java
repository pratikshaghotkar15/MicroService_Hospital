package com.billingService.controllers;

import com.billingService.entities.Billing;
import com.billingService.services.BillingService;
import com.billingService.services.BillingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billings")
public class BillingController {
    @Autowired
    private BillingService billingService;


    @PostMapping("/")
    public ResponseEntity<Billing> create(@RequestBody Billing billing){
        return ResponseEntity.status(HttpStatus.CREATED).body(billingService.create(billing));

    }

    @GetMapping("/{billingId}")
    public ResponseEntity<Billing> getById(@PathVariable("billingId") String billingId){
        return ResponseEntity.status(HttpStatus.OK).body(billingService.getById(billingId));

    }

    @GetMapping("/")
    public ResponseEntity<List<Billing>> getAll(){
        return ResponseEntity.ok(billingService.getall());

    }


    @PutMapping("/{billingId}")
    public ResponseEntity<Billing> update(@PathVariable("billingId") String billingId,@RequestBody  Billing billing){
        return ResponseEntity.ok(billingService.update(billingId,billing));
    }


    @DeleteMapping("/{billingId}")
    public void delete(@PathVariable("billingId") String billingId){

        billingService.delete(billingId);
    }

    @GetMapping("/patient/{patientId}")
    public Billing getBillByPatientId(@PathVariable("patientId") String patientId){
        return billingService.findByPatientId(patientId);
    }



}
