package com.team13.swingbe.domain.auth.service;

import com.team13.swingbe.domain.auth.dto.request.SigninRequest;
import com.team13.swingbe.domain.auth.dto.response.TokenResponse;
import com.team13.swingbe.domain.user.entity.User;
import com.team13.swingbe.domain.user.repository.UserRepository;
import com.team13.swingbe.global.exception.HttpException;
import com.team13.swingbe.global.security.jwt.TokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SigninService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    @Transactional
    public TokenResponse signin(SigninRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new HttpException(HttpStatus.NOT_FOUND, "없는 유저 입니다."));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new HttpException(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다.");
        return tokenProvider.generateTokenSet(user.getId());
    }
}
