package com.team13.swingbe.domain.user.service;

import com.team13.swingbe.domain.user.entity.User;
import com.team13.swingbe.domain.user.repository.UserRepository;
import com.team13.swingbe.global.exception.HttpException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetUser {
    private final UserRepository userRepository;

    @Transactional
    public User getCurrentUser() {
        return userRepository.findByNumber(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new HttpException(HttpStatus.NOT_FOUND, "해당 유저를 찾을 수 없습니다."));
    }
}
