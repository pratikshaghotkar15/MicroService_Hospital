package com.appointmentService.services;

import com.appointmentService.entities.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment  create(Appointment appointment);

    List<Appointment> getAll();
}
