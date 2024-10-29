package com.team13.swingbe.domain.reservation.repository;

import com.team13.swingbe.domain.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE DATE(r.time) = :date AND r.userId = :userId")
    List<Reservation> findByDateAndUserId(@Param("date") LocalDate date, @Param("userId") Long userId);
}
