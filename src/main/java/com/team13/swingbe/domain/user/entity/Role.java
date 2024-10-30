package com.team13.swingbe.domain.user.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum Role {
    ROLE_USER("ROLE_USER"),
    ROLE_TAXI("ROLE_TAXI");

    private final String permission;

}