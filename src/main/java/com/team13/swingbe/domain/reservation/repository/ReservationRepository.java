package com.team13.swingbe.domain.reservation.repository;

import com.team13.swingbe.domain.reservation.entity.Reservation;
import com.team13.swingbe.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUser(User user);

    @Query("SELECT r FROM Reservation r WHERE r.isCall = false")
    List<Reservation> findAllByIsCallFalse();
}
