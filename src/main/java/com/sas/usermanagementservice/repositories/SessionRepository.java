package com.sas.usermanagementservice.repositories;

import com.sas.usermanagementservice.models.Session;
import com.sas.usermanagementservice.models.SessionStatus;
import com.sas.usermanagementservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    int countSessionBySessionStatusAndUser_Id(SessionStatus sessionStatus, Long id);

    Optional<Session> findByTokenAndUser_Id(String token, Long userId);
}