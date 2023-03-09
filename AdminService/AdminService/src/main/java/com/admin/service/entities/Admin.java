package com.admin.service.entities;

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
@Table(name = "admin")
public class Admin {
    @Id
    private String adminId;
    private String name;
    private String email;
    private String  about;

    //@Transient
    //private List<Doctor> doctors_List;

    @Transient
    private List<Patient> listOfPatients;
    @Transient
    private List<Doctor> listOfDoctors;
}
