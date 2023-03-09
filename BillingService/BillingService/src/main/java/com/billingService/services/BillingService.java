package com.billingService.services;

import com.billingService.entities.Billing;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

public interface BillingService {

    //create bill
    Billing create(Billing billing);
    //get bill
    Billing getById(String id);
    //getall
    List<Billing> getall();
    //update
    Billing update(String id,Billing billing);

    //delete
    void delete(String id);

    //find by patientid

    Billing findByPatientId(String patientId);



}
