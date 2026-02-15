package com.hospital.patient_app.repository;

import com.hospital.patient_app.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findByPatientId(String patientId);
    List<Appointment> findByHospitalId(String hospitalId);
}
