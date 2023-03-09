package com.patienthistory.service.services;

import com.patienthistory.service.entities.PatientHistory;

import java.util.List;

public interface PatientHistoryService {

    PatientHistory get(String patientHistoryId);
    List<PatientHistory> getall();

    PatientHistory create(PatientHistory patientHistory);

    PatientHistory update(String id,PatientHistory patientHistory);

    void delete(String id);


}
