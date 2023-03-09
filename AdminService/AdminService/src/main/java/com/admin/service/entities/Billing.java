package com.admin.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Billing {

    private String billingId;
    private  String patientId;

    private String billingStatus;

    private String paidVia;
}
