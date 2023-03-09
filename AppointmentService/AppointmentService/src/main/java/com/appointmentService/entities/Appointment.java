package com.appointmentService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Appointment {

    @Id
    private String AppointmentId;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;

}
