package com.billingService.repositories;

import com.billingService.entities.Billing;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiilingRepository extends JpaRepository<Billing,String> {

    //custom finder methods
    Billing findBypatientId(String patientId);
}
