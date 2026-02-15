package com.hospital.patient_app.service;

import com.hospital.patient_app.model.Patient;
import java.util.Optional;

public interface PatientService {
    Patient register(Patient patient);
    Optional<Patient> findByUsername(String username);
    Optional<Patient> findById(String id);
}
