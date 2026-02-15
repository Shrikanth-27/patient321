package com.hospital.patient_app.service;

import com.hospital.patient_app.model.Hospital;
import java.util.List;

public interface HospitalService {
    List<Hospital> listAll();
    Hospital save(Hospital hospital);
}
