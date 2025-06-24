package com.example.student.Doctor_Record.Service;


import com.example.student.Doctor_Record.Entity.Doctor_Full_Info;
import com.example.student.Doctor_Record.Entity.Doctor_Information;
import com.example.student.Doctor_Record.Entity.Doctor_Personal_Info;
import com.example.student.Doctor_Record.Repository.Doctor_Information_Repository;
import com.example.student.Doctor_Record.Repository.Doctor_Personal_Information_Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class DoctorRecord_Service {
    @Autowired
    private Doctor_Information_Repository doctor_Information_Repository;
    @Autowired
    private Doctor_Personal_Information_Repository doctor_Personal_Information_Repository;

    public boolean SaveNewDoctor(Doctor_Full_Info doctor_Full_Info) {
        Doctor_Information doctor_Information = new Doctor_Information();
        Doctor_Personal_Info doctor_Personal_Info = new Doctor_Personal_Info();

        doctor_Information.setDoctor_id(doctor_Full_Info.getDoctor_id());
        doctor_Information.setDoctor_name(doctor_Full_Info.getDoctor_name());
        doctor_Information.setSpecialization(doctor_Full_Info.getSpecialization());
        doctor_Information.setCabin_no(doctor_Full_Info.getCabin_no());
        doctor_Information.setExperience(doctor_Full_Info.getExperience());
        doctor_Information.setAverage_charge(doctor_Full_Info.getAverage_charge());
        doctor_Information.setGender(doctor_Full_Info.getGender());

        doctor_Personal_Info.setDoctor_id(doctor_Full_Info.getDoctor_id());
        doctor_Personal_Info.setDoctor_name(doctor_Full_Info.getDoctor_name());
        doctor_Personal_Info.setDoctor_phone(doctor_Full_Info.getDoctor_phone());
        doctor_Personal_Info.setDoctor_email(doctor_Full_Info.getEmail());
        doctor_Personal_Info.setDoctor_address(doctor_Full_Info.getDoctor_address());

        doctor_Information_Repository.save(doctor_Information);
        doctor_Personal_Information_Repository.save(doctor_Personal_Info);
        return true;
    }
    public Optional<Doctor_Full_Info> get_Doctor_Full_Info(String id) {
        Optional<Doctor_Information> doctor_Information = get_Doctor_Information(id);
        Optional<Doctor_Personal_Info> doctor_Personal_Info =get_Doctor_Personal_Info(id);
        Doctor_Full_Info doctor_Full_Info = new Doctor_Full_Info();
        if(doctor_Information.isPresent() && doctor_Personal_Info.isPresent()){
            doctor_Full_Info.setDoctor_id(doctor_Information.get().getDoctor_id());
            doctor_Full_Info.setDoctor_name(doctor_Information.get().getDoctor_name());
            doctor_Full_Info.setSpecialization(doctor_Information.get().getSpecialization());
            doctor_Full_Info.setCabin_no(doctor_Information.get().getCabin_no());
            doctor_Full_Info.setExperience(doctor_Information.get().getExperience());
            doctor_Full_Info.setAverage_charge(doctor_Information.get().getAverage_charge());
            doctor_Full_Info.setGender(doctor_Information.get().getGender());

            doctor_Full_Info.setDoctor_phone(doctor_Personal_Info.get().getDoctor_phone());
            doctor_Full_Info.setDoctor_address(doctor_Personal_Info.get().getDoctor_address());
            doctor_Full_Info.setEmail(doctor_Personal_Info.get().getDoctor_email());

        }
        return Optional.of(doctor_Full_Info);
    }
    public Optional<Doctor_Personal_Info> get_Doctor_Personal_Info(String id) {
        return doctor_Personal_Information_Repository.findById(id);
    }

    public Optional<Doctor_Information> get_Doctor_Information(String id) {
        return doctor_Information_Repository.findById(id);
    }
    public List<Doctor_Full_Info> getAllDoctor_Full_Info() {
        List<Doctor_Personal_Info> doctor_Personal_Info =doctor_Personal_Information_Repository.findAll();
        List<String> doctor_id=new ArrayList<>();
        for(Doctor_Personal_Info i:doctor_Personal_Info){
            doctor_id.add(i.getDoctor_id());
        }
        List<Doctor_Full_Info> doctor_Full_Info=new ArrayList<>();
        for(String i: doctor_id){
            Optional<Doctor_Full_Info> temp=get_Doctor_Full_Info(i);
            temp.ifPresent(doctor_Full_Info::add);
        }
        return doctor_Full_Info;
    }

    public boolean updateDoctor(Doctor_Full_Info updatedInfo) {
        Optional<Doctor_Information> existingInfoOpt = doctor_Information_Repository.findById(updatedInfo.getDoctor_id());
        Optional<Doctor_Personal_Info> existingPersonalOpt = doctor_Personal_Information_Repository.findById(updatedInfo.getDoctor_id());

        if (existingInfoOpt.isPresent() && existingPersonalOpt.isPresent()) {
            Doctor_Information info = existingInfoOpt.get();
            info.setDoctor_name(updatedInfo.getDoctor_name());
            info.setSpecialization(updatedInfo.getSpecialization());
            info.setCabin_no(updatedInfo.getCabin_no());
            info.setExperience(updatedInfo.getExperience());
            info.setAverage_charge(updatedInfo.getAverage_charge());
            info.setGender(updatedInfo.getGender());
            doctor_Information_Repository.save(info);

            Doctor_Personal_Info personal = existingPersonalOpt.get();
            personal.setDoctor_name(updatedInfo.getDoctor_name());
            personal.setDoctor_phone(updatedInfo.getDoctor_phone());
            personal.setDoctor_email(updatedInfo.getEmail());
            personal.setDoctor_address(updatedInfo.getDoctor_address());
            doctor_Personal_Information_Repository.save(personal);

            return true;
        }

        return false;
    }

    public boolean deleteDoctor(String doctorId) {
        boolean existsInfo = doctor_Information_Repository.existsById(doctorId);
        boolean existsPersonal = doctor_Personal_Information_Repository.existsById(doctorId);

        if (existsInfo && existsPersonal) {
            doctor_Information_Repository.deleteById(doctorId);
            doctor_Personal_Information_Repository.deleteById(doctorId);
            return true;
        }

        return false;
    }

    public boolean doctorExists(String doctorId) {
        return doctor_Information_Repository.existsById(doctorId)
                && doctor_Personal_Information_Repository.existsById(doctorId);
    }
}
