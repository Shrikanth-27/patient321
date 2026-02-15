package com.hospital.patient_app.controller;

import com.hospital.patient_app.dto.AppointmentRequest;
import com.hospital.patient_app.model.Appointment;
import com.hospital.patient_app.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment create(@RequestBody AppointmentRequest req) {
        Appointment a = new Appointment();
        a.setPatientId(req.getPatientId());
        a.setHospitalId(req.getHospitalId());
        a.setAppointmentAt(req.getAppointmentAt());
        a.setNotes(req.getNotes());
        return appointmentService.create(a);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> byPatient(@PathVariable String patientId) {
        return appointmentService.findByPatientId(patientId);
    }
}
