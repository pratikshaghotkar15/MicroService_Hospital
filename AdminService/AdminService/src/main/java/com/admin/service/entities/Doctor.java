package com.admin.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {
    private String doctorId;
    private String name;
    private String degree;
    private String specialistOf;
    private String contactNo;

}
