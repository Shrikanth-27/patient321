package com.hospital.patient_app.service;

import com.hospital.patient_app.model.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment create(Appointment appointment);
    List<Appointment> findByPatientId(String patientId);
}
