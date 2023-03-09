package com.patienthistory.service.services;

import com.patienthistory.service.entities.PatientHistory;
import com.patienthistory.service.exceptions.ResourceNotFoundException;
import com.patienthistory.service.repositories.PatienthistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService{
    @Autowired
    private PatienthistoryRepository patienthistoryRepository;

    @Override
    public PatientHistory get(String patientHistoryId) {
        return patienthistoryRepository.findById(patientHistoryId).orElseThrow(()->new ResourceNotFoundException("history not found with"));
    }

    @Override
    public List<PatientHistory> getall() {
        return patienthistoryRepository.findAll();
    }

    @Override
    public PatientHistory create(PatientHistory patientHistory) {
        String id=UUID.randomUUID().toString();
        patientHistory.setPatientHistoryId(id);
        return patienthistoryRepository.save(patientHistory);
    }

    @Override
    public PatientHistory update(String id, PatientHistory patientHistory) {
        patientHistory.setPatientHistoryId(id);
        PatientHistory patientHistory1=patienthistoryRepository.save(patientHistory);
        return patientHistory1;
    }

    @Override
    public void delete(String id) {
        patienthistoryRepository.deleteById(id);

    }
}
