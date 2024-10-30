package com.team13.swingbe.domain.reservation.repository;

import com.team13.swingbe.domain.reservation.entity.Reservation;
import com.team13.swingbe.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByDateAndUser(String date, User user);
}
