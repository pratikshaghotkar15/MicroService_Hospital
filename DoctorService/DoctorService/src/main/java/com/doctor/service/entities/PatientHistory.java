package com.doctor.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientHistory {

    private String patientHistoryId;

    private String past_medical_issue;
    private String is_there_any_pastSurgery_Y_N;
    private String type_of_surgery;
    private String timeofOperation;
    private String branch_of_hospital;

}
