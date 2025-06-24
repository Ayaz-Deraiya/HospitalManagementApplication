package com.example.student.SessionBooking.Controller;

import com.example.student.SessionBooking.Entity.DateRequest;
import com.example.student.SessionBooking.Entity.FilterByDateAndDoctorId;
import com.example.student.SessionBooking.Entity.FilterByDoctorId;
import com.example.student.SessionBooking.Entity.Session;
import com.example.student.SessionBooking.Service.SessionBooking_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionBooking_Controller {
    @Autowired
    private SessionBooking_Service sessionBookingService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSession(@RequestBody Session session) {
        boolean saved = sessionBookingService.SaveSession(session);
        return saved ? ResponseEntity.ok("Session saved successfully.")
                : ResponseEntity.status(500).body("Failed to save session.");
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> sessionExists(@PathVariable("id") long sessionId) {
        boolean exists = sessionBookingService.SessionExists(sessionId);
        return ResponseEntity.ok(exists);
    }
    @PostMapping("/addMultipleSession")
    public ResponseEntity<String> saveSession(@RequestBody List<Session> session) {
        boolean saved=true;
        for(Session session1 : session) {
            saved&=sessionBookingService.SaveSession(session1);
        }
        return saved ? ResponseEntity.ok("Session saved successfully.")
                : ResponseEntity.status(500).body("Failed to save session.");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSession(@PathVariable("id") long sessionId) {
        boolean deleted = sessionBookingService.DeleteSession(sessionId);
        return deleted ? ResponseEntity.ok("Session deleted successfully.")
                : ResponseEntity.status(404).body("Session not found.");
    }
    @PostMapping("/getSessionsByDate")
    public List<Session> getSessionsByDate(@RequestBody DateRequest dateRequest) {
        return sessionBookingService.getSessionsByDate(dateRequest);
    }
    @PostMapping("/FilterByDoctorId")
    public List<Session> FilterByDoctorId(@RequestBody FilterByDoctorId filterByDoctorId) {
        return sessionBookingService.getSessionsByDoctorId(filterByDoctorId);
    }
    @PostMapping("/getSessionsByDoctorIdAndDate")
    public List<Session> getSessionsByDoctorIdAndDate(@RequestBody FilterByDateAndDoctorId filterByDateAndDoctorId) {
        return sessionBookingService.getSessionsByDoctorIdAndDate(filterByDateAndDoctorId.getFilterByDoctorId(),filterByDateAndDoctorId.getDateRequest());
    }
    @GetMapping("/allSession")
    public List<Session> getAllSession() {
        return sessionBookingService.getAllSessions();
    }
}

