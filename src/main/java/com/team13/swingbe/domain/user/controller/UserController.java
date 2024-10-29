package com.team13.swingbe.domain.user.controller;

import com.team13.swingbe.domain.user.controller.dto.response.UserInfoResponse;
import com.team13.swingbe.domain.user.entity.User;
import com.team13.swingbe.domain.user.service.GetUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final GetUser getUser;

    @GetMapping("/my-info")
    public UserInfoResponse getUserInfo() {
        User user = getUser.getCurrentUser();
        return new UserInfoResponse(user.getName(), user.getNumber());
    }
}
