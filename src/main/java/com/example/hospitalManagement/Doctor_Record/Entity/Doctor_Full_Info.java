package com.example.hospitalManagement.Doctor_Record.Entity;

public class Doctor_Full_Info {
    private String doctor_id;
    private String doctor_name;
    private String doctor_phone;
    private String doctor_address;
    private String specialization;
    private String cabin_no;
    private String experience;
    private Double average_charge;
    private String email;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDoctor_address() {
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
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

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
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
