package com.hospital.patient_app.repository;

import com.hospital.patient_app.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findByUsername(String username);
    Optional<Patient> findByEmail(String email);
}
