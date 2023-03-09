package com.appointmentService.services;

import com.appointmentService.entities.Appointment;
import com.appointmentService.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment create(Appointment appointment) {
        String  id=UUID.randomUUID().toString();
        appointment.setAppointmentId(id);
        return appointmentRepository.save(appointment);

    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
}
