package com.team13.swingbe.domain.auth.controller;

import com.team13.swingbe.domain.auth.dto.request.SigninRequest;
import com.team13.swingbe.domain.auth.dto.request.SignupRequest;
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

    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signup(@RequestBody @Valid SignupRequest request) {
        TokenResponse response = signupService.signup(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signin(@RequestBody @Valid SigninRequest request) {
        TokenResponse response = signinService.signin(request);
        return ResponseEntity.ok(response);
    }
}
