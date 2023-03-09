package com.doctor.service.externalservices;

import com.doctor.service.entities.PatientHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENTHISTORY-SERVICE")
public interface PatientHistoryService {

    @GetMapping("/patienthistory/{patienthistoryId}")
    PatientHistory getPatientHistory(@PathVariable("patienthistoryId") String patienthistoryId);
}
