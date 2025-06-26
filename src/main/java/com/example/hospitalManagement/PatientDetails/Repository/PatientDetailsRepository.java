package com.example.hospitalManagement.PatientDetails.Repository;

import com.example.hospitalManagement.PatientDetails.Entity.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {
}
