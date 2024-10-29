package com.team13.swingbe.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team13.swingbe.domain.reservation.entity.Reservation;
import com.team13.swingbe.global.auth.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "user")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    private String name;

    private String number;

    private String gender;

    private String age;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Convert(converter = StringListConverter.class)
    private List<Role> roles;
}