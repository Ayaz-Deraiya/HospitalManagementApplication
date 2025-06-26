package com.example.hospitalManagement.SessionBooking.Entity;

public class FilterByDateAndDoctorId {
    private DateRequest dateRequest;
    private FilterByDoctorId filterByDoctorId;

    public DateRequest getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(DateRequest dateRequest) {
        this.dateRequest = dateRequest;
    }

    public FilterByDoctorId getFilterByDoctorId() {
        return filterByDoctorId;
    }

    public void setFilterByDoctorId(FilterByDoctorId filterByDoctorId) {
        this.filterByDoctorId = filterByDoctorId;
    }
}
