package com.billingService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "billingdetails")
public class Billing {
    @Id
    private String billingId;
    private  String patientId;

    private String billingStatus;

    private String paidVia;
   // @Transient
    //private List<Patient> patientData;

}
