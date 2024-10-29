package com.team13.swingbe.domain.reservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private String origin;

    private String destination;

    private String time;

    private String charge;

    private String personnel;

    private String request;
}
