package com.example.hospitalManagement.Doctor_Record.Repository;

import com.example.hospitalManagement.Doctor_Record.Entity.Doctor_Personal_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Doctor_Personal_Information_Repository extends JpaRepository<Doctor_Personal_Info,String> {
}
