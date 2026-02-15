package com.hospital.patient_app.controller;

import com.hospital.patient_app.dto.LoginRequest;
import com.hospital.patient_app.dto.RegisterRequest;
import com.hospital.patient_app.model.Patient;
import com.hospital.patient_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final PatientService patientService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(PatientService patientService, PasswordEncoder passwordEncoder) {
        this.patientService = patientService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        // basic validation
        if (req.getUsername() == null || req.getPassword() == null) {
            return ResponseEntity.badRequest().body("username and password required");
        }
        Optional<Patient> existing = patientService.findByUsername(req.getUsername());
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body("username already exists");
        }
        Patient p = new Patient();
        p.setFirstName(req.getFirstName());
        p.setLastName(req.getLastName());
        p.setEmail(req.getEmail());
        p.setPhone(req.getPhone());
        p.setUsername(req.getUsername());
        p.setPassword(req.getPassword());
        Patient saved = patientService.register(p);
        saved.setPassword(null);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        Optional<Patient> p = patientService.findByUsername(req.getUsername());
        if (p.isEmpty()) return ResponseEntity.status(401).body("invalid credentials");
        Patient patient = p.get();
        if (!passwordEncoder.matches(req.getPassword(), patient.getPassword())) {
            return ResponseEntity.status(401).body("invalid credentials");
        }
        patient.setPassword(null);
        return ResponseEntity.ok(patient);
    }
}
