package com.example.student.SessionBooking.Service;

import com.example.student.SessionBooking.Entity.DateRequest;
import com.example.student.SessionBooking.Entity.FilterByDoctorId;
import com.example.student.SessionBooking.Entity.Session;
import com.example.student.SessionBooking.Repository.SessionBooking_Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class SessionBooking_Service {
    @Autowired
    private SessionBooking_Repository repo;
    public boolean SaveSession(Session session) {
        repo.save(session);
        return true;
    }
    public boolean SessionExists(long sessionId) {
        return repo.findById(sessionId).isPresent();
    }
    public boolean DeleteSession(long sessionId) {
        Optional<Session> session = repo.findById(sessionId);
        if(session.isPresent()) {
            repo.delete(session.get());
            return true;
        }
        return false;
    }
    public List<Session> getSessionsByDate(DateRequest dateRequest) {
        return repo.getSessionsByDate(dateRequest.getDate());
    }
    public List<Session> getSessionsByDoctorId(FilterByDoctorId filterByDoctorId) {
        return repo.getSessionsByDoctorId(filterByDoctorId.getDoctorId());
    }
    public List<Session> getSessionsByDoctorIdAndDate(FilterByDoctorId filterByDoctorId, DateRequest dateRequest) {
        return repo.getSessionsByDoctorIdAndDate(filterByDoctorId.getDoctorId(), dateRequest.getDate());
    }
    public List<Session> getAllSessions() {
        return repo.findAll();
    }
}
