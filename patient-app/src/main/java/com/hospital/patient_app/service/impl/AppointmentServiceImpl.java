package com.hospital.patient_app.service.impl;

import com.hospital.patient_app.model.Appointment;
import com.hospital.patient_app.repository.AppointmentRepository;
import com.hospital.patient_app.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findByPatientId(String patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}
