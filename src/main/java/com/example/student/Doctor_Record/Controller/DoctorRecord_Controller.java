package com.example.student.Doctor_Record.Controller;

import com.example.student.Doctor_Record.Entity.Doctor_Full_Info;
import com.example.student.Doctor_Record.Entity.Doctor_Information;
import com.example.student.Doctor_Record.Entity.Doctor_Personal_Info;
import com.example.student.Doctor_Record.Service.DoctorRecord_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/doctorInfo")
public class DoctorRecord_Controller {
    @Autowired
    private DoctorRecord_Service doctorRecordService;

    @PostMapping("/saveNewDoctor")
    public boolean SaveNewDoctor(@RequestBody Doctor_Full_Info doctor_full_info){
        return doctorRecordService.SaveNewDoctor(doctor_full_info);
    }
    @PostMapping("/")
    public boolean SaveMultipleDoctors(@RequestBody List<Doctor_Full_Info> doctor_full_info){
        for(Doctor_Full_Info i:doctor_full_info){
            SaveNewDoctor(i);
        }
        return true;
    }
    @GetMapping("/fullInfo/{id}")
    public Optional<Doctor_Full_Info> getDoctorInfoById(@PathVariable String id){
        return doctorRecordService.get_Doctor_Full_Info(id);
    }
    @GetMapping("/personalInfo/{id}")
    public Optional<Doctor_Personal_Info> getDoctorPersonalInfoById(@PathVariable String id){
        return doctorRecordService.get_Doctor_Personal_Info(id);
    }
    @GetMapping("/DoctorInfo/{id}")
    public Optional<Doctor_Information> getAllDoctorInfo(@PathVariable String id){
        return doctorRecordService.get_Doctor_Information(id);
    }
    @GetMapping("/allDoctorInfo")
    public List<Doctor_Full_Info> getAllDoctorFullInfo(){
        return doctorRecordService.getAllDoctor_Full_Info();
    }

    @PutMapping("/update")
    public String updateDoctor(@RequestBody Doctor_Full_Info doctorFullInfo) {
        boolean updated = doctorRecordService.updateDoctor(doctorFullInfo);
        return updated ? "Doctor updated successfully!" : "Doctor not found or update failed.";
    }

    // Delete doctor by ID
    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable String id) {
        boolean deleted = doctorRecordService.deleteDoctor(id);
        return deleted ? "Doctor deleted successfully!" : "Doctor not found.";
    }

    // Check if doctor exists
    @GetMapping("/exists/{id}")
    public String checkDoctorExists(@PathVariable String id) {
        boolean exists = doctorRecordService.doctorExists(id);
        return exists ? "Doctor exists." : "Doctor does not exist.";
    }
}
