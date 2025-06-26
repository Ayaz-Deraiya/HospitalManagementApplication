package com.example.hospitalManagement.PatientDetails.Service;

import com.example.hospitalManagement.PatientDetails.Entity.PatientDetails;
import com.example.hospitalManagement.PatientDetails.Repository.PatientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class PatientDetails_Service {
    @Autowired
    private PatientDetailsRepository repository;

    // Save patient details
    public PatientDetails savePatient(PatientDetails patient) {
        return repository.save(patient);
    }

    // Get all patients
    public List<PatientDetails> getAllPatients() {
        return repository.findAll();
    }

    // Get patient by ID
    public PatientDetails getPatientById(Long id) {
        Optional<PatientDetails> patient = repository.findById(id);
        return patient.orElse(null);
    }

    // Update patient details
    public PatientDetails updatePatient(Long id, PatientDetails updatedPatient) {
        PatientDetails existingPatient = getPatientById(id);
        if (existingPatient == null) {
            return null;
        }
        existingPatient.setName(updatedPatient.getName());
        existingPatient.setGender(updatedPatient.getGender());
        existingPatient.setAge(updatedPatient.getAge());
        existingPatient.setAddress(updatedPatient.getAddress());
        existingPatient.setPhone(updatedPatient.getPhone());
        existingPatient.setEmail(updatedPatient.getEmail());
        return repository.save(existingPatient);
    }

    // Delete patient
    public boolean deletePatient(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
