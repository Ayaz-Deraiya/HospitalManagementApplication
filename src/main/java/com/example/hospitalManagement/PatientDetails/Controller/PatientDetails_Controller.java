package com.example.hospitalManagement.PatientDetails.Controller;

import com.example.hospitalManagement.PatientDetails.Entity.PatientDetails;
import com.example.hospitalManagement.PatientDetails.Service.PatientDetails_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientDetails_Controller {
    @Autowired
    private PatientDetails_Service patientDetailsService;

    @PostMapping
    public PatientDetails savePatient(@RequestBody PatientDetails patient) {
        return patientDetailsService.savePatient(patient);
    }
    @PostMapping("/MultipleUsers")
    public boolean SaveMultiplePatients(@RequestBody List<PatientDetails> patients) {
        for (PatientDetails patientDetails : patients) {
            patientDetailsService.savePatient(patientDetails);
        }
        return true;
    }
    @GetMapping
    public List<PatientDetails> getAllPatients() {
        return patientDetailsService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDetails getPatientById(@PathVariable Long id) {
        return patientDetailsService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public PatientDetails updatePatient(@PathVariable Long id, @RequestBody PatientDetails updatedPatient) {
        return patientDetailsService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        return patientDetailsService.deletePatient(id) ? "Patient deleted successfully" : "Patient not found";
    }
}
