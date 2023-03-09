package com.doctor.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctors_list")
public class Doctor {
    @Id
    private String doctorId;
    private String name;
    private String degree;
    private String specialistOf;
    private String contactNo;

    @Transient
    private List<Patient> listOfPatients;

}
