package com.team13.swingbe.domain.driver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MyCallsResponse {
    private Long id;
    private String date;
    private String time;
    private String origin;
    private String destination;
    private String charge;
}
