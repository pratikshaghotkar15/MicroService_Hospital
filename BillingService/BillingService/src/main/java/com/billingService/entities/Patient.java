package com.billingService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private String patientId;
    private String patientName;
    private String disease;
    private String status;
    private String doctorId;

}
