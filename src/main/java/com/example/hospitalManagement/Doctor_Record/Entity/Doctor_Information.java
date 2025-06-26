package com.example.hospitalManagement.Doctor_Record.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Doctor_Information {
    @Id
    private String doctor_id;
    private String doctor_name;
    private String specialization;
    private String cabin_no;
    private String experience;
    private Double average_charge;
    private String Gender;

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Double getAverage_charge() {
        return average_charge;
    }

    public void setAverage_charge(Double average_charge) {
        this.average_charge = average_charge;
    }

    public String getCabin_no() {
        return cabin_no;
    }

    public void setCabin_no(String cabin_no) {
        this.cabin_no = cabin_no;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
