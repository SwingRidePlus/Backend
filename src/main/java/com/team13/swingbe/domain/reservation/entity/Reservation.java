package com.team13.swingbe.domain.reservation.entity;

import com.team13.swingbe.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "reservation")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String origin;
    private String destination;
    private String time;
    private String charge;
    private String personnel;
    private String request;
}
