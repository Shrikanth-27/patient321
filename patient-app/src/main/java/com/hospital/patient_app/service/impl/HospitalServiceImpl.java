package com.hospital.patient_app.service.impl;

import com.hospital.patient_app.model.Hospital;
import com.hospital.patient_app.repository.HospitalRepository;
import com.hospital.patient_app.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Hospital> listAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
}
