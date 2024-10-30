package com.team13.swingbe.domain.auth.controller;

import com.team13.swingbe.domain.auth.dto.request.SigninRequest;
import com.team13.swingbe.domain.auth.dto.request.SignupTaxiRequest;
import com.team13.swingbe.domain.auth.dto.request.SignupUserRequest;
import com.team13.swingbe.domain.auth.dto.response.TokenResponse;
import com.team13.swingbe.domain.auth.service.SigninService;
import com.team13.swingbe.domain.auth.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final SignupService signupService;
    private final SigninService signinService;

    @PostMapping("/signup/user")
    public ResponseEntity<TokenResponse> signupUser(@RequestBody @Valid SignupUserRequest request) {
        TokenResponse response = signupService.signupUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup/taxi")
    public ResponseEntity<TokenResponse> signupTaxi(@RequestBody @Valid SignupTaxiRequest request) {
        TokenResponse response = signupService.signupTaxi(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signin(@RequestBody @Valid SigninRequest request) {
        TokenResponse response = signinService.signin(request);
        return ResponseEntity.ok(response);
    }
}
