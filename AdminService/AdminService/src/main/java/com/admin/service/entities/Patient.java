package com.admin.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private String patientId;
    private String patientName;
    private String disease;
    private String status;
    @Transient
    private Billing billingStatus;
}
