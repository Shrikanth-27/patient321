package com.hospital.patient_app.service.impl;

import com.hospital.patient_app.model.Patient;
import com.hospital.patient_app.repository.PatientRepository;
import com.hospital.patient_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final com.hospital.patient_app.repository.PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PatientServiceImpl(com.hospital.patient_app.repository.PatientRepository patientRepository, PasswordEncoder passwordEncoder) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Patient register(Patient patient) {
        // hash password
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public Optional<Patient> findById(String id) {
        return patientRepository.findById(id);
    }
}
