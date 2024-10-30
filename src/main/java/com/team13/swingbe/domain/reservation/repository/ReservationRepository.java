package com.team13.swingbe.domain.reservation.repository;

import com.team13.swingbe.domain.reservation.entity.Reservation;
import com.team13.swingbe.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByDateAndUser(LocalDate date, User user);
}
