package com.patient.service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("patient_details")
@Builder
public class Patient {
    @Id
    private String patientId;
    private String patientName;
    private String disease;
    private String status;

    private String doctorId;

    private String patientHistoryId;

    @Transient
    private Billing billingStatus;
}
