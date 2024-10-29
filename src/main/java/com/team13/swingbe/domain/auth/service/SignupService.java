package com.team13.swingbe.domain.auth.service;

import com.team13.swingbe.domain.auth.dto.request.SignupRequest;
import com.team13.swingbe.domain.auth.dto.response.TokenResponse;
import com.team13.swingbe.domain.user.entity.Role;
import com.team13.swingbe.domain.user.entity.User;
import com.team13.swingbe.domain.user.repository.UserRepository;
import com.team13.swingbe.global.exception.HttpException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse signup(SignupRequest request) {
        if(userRepository.existsUserByEmail(request.getEmail()))
            throw new HttpException(HttpStatus.BAD_REQUEST, "이미 해당 이름을 사용하는 멤버가 존재합니다.");
        User user = User.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .age(request.getAge())
                .roles(List.of(Role.ROLE_USER))
                .build();
        userRepository.save(user);
        return null;
    }
}