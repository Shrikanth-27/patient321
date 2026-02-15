package com.hospital.patient_app.repository;

import com.hospital.patient_app.model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalRepository extends MongoRepository<Hospital, String> {
}
