package com.team13.swingbe.domain.reservation.controller;

import com.team13.swingbe.domain.reservation.dto.request.ReservationRequest;
import com.team13.swingbe.domain.reservation.dto.response.ReservationDateResponse;
import com.team13.swingbe.domain.reservation.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public void reservation(@RequestBody @Valid ReservationRequest request) {
        reservationService.reservation(request);
    }

    @GetMapping("/reservation")
    public List<ReservationDateResponse> reservationsDate() {
        return reservationService.reservationDate();
    }

    @PatchMapping("/reservation/price/{id}")
    public void updateCharge(@PathVariable Long id, @RequestParam("charge") String charge) {
        reservationService.updateCharge(id, charge);
    }

    @DeleteMapping("/reservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
