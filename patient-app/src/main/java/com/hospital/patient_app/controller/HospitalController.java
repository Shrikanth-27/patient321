package com.hospital.patient_app.controller;

import com.hospital.patient_app.model.Hospital;
import com.hospital.patient_app.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public List<Hospital> list() {
        return hospitalService.listAll();
    }

    @PostMapping
    public Hospital create(@RequestBody Hospital hospital) {
        return hospitalService.save(hospital);
    }
}
