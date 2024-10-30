package com.team13.swingbe.domain.driver.service;

import com.team13.swingbe.domain.driver.dto.response.CallsResponse;
import com.team13.swingbe.domain.reservation.entity.Reservation;
import com.team13.swingbe.domain.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CallService {
    private final ReservationRepository reservationRepository;
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

}
