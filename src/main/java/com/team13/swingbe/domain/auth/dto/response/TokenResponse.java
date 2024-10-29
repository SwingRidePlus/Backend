package com.team13.swingbe.domain.auth.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {
    private String access;
    private String refresh;
}