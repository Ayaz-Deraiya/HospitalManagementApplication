package com.example.student.SessionBooking.Repository;

import com.example.student.SessionBooking.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface SessionBooking_Repository extends JpaRepository<Session,Long> {
    @Query("SELECT s FROM Session s WHERE s.date=?1")
    List<Session> getSessionsByDate(LocalDate localDate);

    @Query("SELECT s FROM Session s WHERE s.doctor_id=?1")
    List<Session> getSessionsByDoctorId(String doctorId);

    @Query("SELECT s FROM Session s WHERE s.doctor_id=?1 and s.date=?2")
    List<Session> getSessionsByDoctorIdAndDate(String doctorId, LocalDate date);
}
