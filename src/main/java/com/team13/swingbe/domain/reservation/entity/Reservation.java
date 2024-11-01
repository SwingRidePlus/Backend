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

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;

    private String origin;
    private String destination;
    private String date;
    private String time;
    private String charge;
    private String personnel;
    private String request;
    private Boolean isCall;

    public void changeCharge(String charge) {
        this.charge = charge;
    }

    public void call(Boolean isCall, User driver) {
        this.isCall = isCall;
        this.driver = driver;
    }
}
