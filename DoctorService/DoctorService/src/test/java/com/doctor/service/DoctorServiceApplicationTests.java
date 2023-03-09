package com.doctor.service;

import com.doctor.service.entities.Patient;
import com.doctor.service.externalservices.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DoctorServiceApplicationTests {
	@Autowired
	private PatientService patientService;

	@Test
	void contextLoads() {
	}

	//@Test
	//void createPatient(){

		//Patient patient=Patient.builder().patientHistoryId("").patientName("pp").disease("dd").status("ss").build();
		//Patient savedPatient=patientService.createPatient(patient);
		//System.out.println("new patient created");
	//}

}
