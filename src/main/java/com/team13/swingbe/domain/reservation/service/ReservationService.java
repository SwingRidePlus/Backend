package com.team13.swingbe.domain.reservation.service;

import com.team13.swingbe.domain.reservation.dto.request.ReservationRequest;
import com.team13.swingbe.domain.reservation.dto.response.ReservationDateResponse;
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
                .date(request.getDate())
                .build();

        reservationRepository.save(reservation);
    }

    public List<ReservationDateResponse> reservationDate() {
        User user = getUser.getCurrentUser();
        List<Reservation> reservations = reservationRepository.findAllByUser(user);

        return reservations.stream()
                .map(reservation -> new ReservationDateResponse(
                        reservation.getId(),
                        reservation.getDate(),
                        reservation.getTime(),
                        reservation.getOrigin(),
                        reservation.getDestination()
                ))
                .collect(Collectors.toList());
    }

    public void updateCharge(Long id, String charge) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.changeCharge(charge);
        reservationRepository.save(reservation);
    }
}
