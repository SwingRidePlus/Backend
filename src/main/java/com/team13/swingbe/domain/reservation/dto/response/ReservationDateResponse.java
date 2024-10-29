package com.team13.swingbe.domain.reservation.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationDateResponse {
    private String date;
    private String time;
    private String origin;
    private String destination;
}
