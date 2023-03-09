package com.billingService.services;

import com.billingService.entities.Billing;
import com.billingService.exceptions.ResourceNotFoundException;
import com.billingService.repositories.BiilingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillingServiceImpl implements BillingService{
    @Autowired
    private BiilingRepository biilingRepository;

    @Override
    public Billing create(Billing billing) {
        String id=UUID.randomUUID().toString();
        billing.setBillingId(id);
        return biilingRepository.save(billing);
    }

    @Override
    public Billing getById(String id) {
        return biilingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("bill not found"));
    }

    @Override
    public List<Billing> getall() {
        return biilingRepository.findAll();
    }

    @Override
    public Billing update(String id, Billing billing) {
        billing.setBillingId(id);
        Billing billing1=biilingRepository.save(billing);
        return billing1;
    }

    @Override
    public void delete(String id) {
        biilingRepository.deleteById(id);

    }

    @Override
    public Billing findByPatientId(String patientId) {
        return biilingRepository.findBypatientId(patientId);
    }
}
