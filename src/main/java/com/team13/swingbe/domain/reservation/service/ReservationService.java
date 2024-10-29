package com.team13.swingbe.domain.reservation.service;

import com.team13.swingbe.domain.reservation.dto.request.ReservationRequest;
import com.team13.swingbe.domain.reservation.dto.response.ReservationDateResponse;
import com.team13.swingbe.domain.reservation.entity.Reservation;
import com.team13.swingbe.domain.reservation.repository.ReservationRepository;
import com.team13.swingbe.domain.user.entity.User;
import com.team13.swingbe.domain.user.service.GetUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final GetUser getUser;
    private final ReservationRepository reservationRepository;

    public void reservation(ReservationRequest request) {
        User user = getUser.getCurrentUser();
        Reservation reservation = Reservation.builder()
                .charge(request.getCharge())
                .destination(request.getDestination())
                .origin(request.getOrigin())
                .personnel(request.getPersonnel())
                .time(request.getTime())
                .request(request.getRequest())
                .user(user)
                .build();

        reservationRepository.save(reservation);
    }

    public List<ReservationDateResponse> reservationDate(LocalDate localDate) {
        User user = getUser.getCurrentUser();
        List<Reservation> reservations = reservationRepository.findByDateAndUserId(localDate, user.getId());

        return reservations.stream()
                .map(reservation -> new ReservationDateResponse(
                        localDate.toString(),
                        reservation.getTime().toString(),
                        reservation.getOrigin(),
                        reservation.getDestination()
                ))
                .collect(Collectors.toList());
    }
}
