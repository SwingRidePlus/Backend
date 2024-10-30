package com.team13.swingbe.domain.driver.service;

import com.team13.swingbe.domain.driver.dto.response.CallsResponse;
import com.team13.swingbe.domain.reservation.entity.Reservation;
import com.team13.swingbe.domain.reservation.repository.ReservationRepository;
import com.team13.swingbe.domain.user.entity.User;
import com.team13.swingbe.domain.user.service.GetUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CallService {
    private final ReservationRepository reservationRepository;
    private final GetUser getUser;
    public List<CallsResponse> calls() {
        List<Reservation> reservations = reservationRepository.findAllByIsCallFalse();

        return reservations.stream()
                .map(reservation -> CallsResponse.builder()
                        .id(reservation.getId())
                        .date(reservation.getDate())
                        .charge(reservation.getCharge())
                        .time(reservation.getTime())
                        .origin(reservation.getOrigin())
                        .destination(reservation.getDestination())
                        .build())
                .collect(Collectors.toList());
    }

    public void call(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        User user = getUser.getCurrentUser();
        reservation.call(true, user);
        reservationRepository.save(reservation);
    }
}
