package com.patienthistory.service.repositories;

import com.patienthistory.service.entities.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatienthistoryRepository extends JpaRepository<PatientHistory,String> {


}
