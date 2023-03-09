package com.doctor.service.entities;

import lombok.*;
import org.springframework.data.annotation.Transient;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    private String patientId;
    private String patientName;
    private String disease;
    private String status;

    private String doctorId;
    private String patientHistoryId;

    private PatientHistory patientHistory;

    //@Transient
    //private Billing billingStatus;
}
