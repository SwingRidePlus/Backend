package com.team13.swingbe.domain.reservation.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReservationDateResponse {
    private Long id;
    private String date;
    private String time;
    private String origin;
    private String destination;
    private String charge;
    private Boolean isCall;
}
