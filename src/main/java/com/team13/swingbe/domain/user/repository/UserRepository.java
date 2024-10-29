package com.team13.swingbe.domain.user.repository;

import com.team13.swingbe.domain.user.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNumber(String number);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    boolean existsUserByNumber(String number);
}