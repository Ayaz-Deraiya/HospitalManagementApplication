package com.example.student.Doctor_Record.Repository;

import com.example.student.Doctor_Record.Entity.Doctor_Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Doctor_Information_Repository extends JpaRepository<Doctor_Information,String> {
}
