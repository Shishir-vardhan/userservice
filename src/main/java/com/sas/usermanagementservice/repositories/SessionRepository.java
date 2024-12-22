package com.sas.usermanagementservice.repositories;

import com.sas.usermanagementservice.models.Session;
import com.sas.usermanagementservice.models.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    int countSessionBySessionStatusAndUserId(SessionStatus sessionStatus, Long id);
}