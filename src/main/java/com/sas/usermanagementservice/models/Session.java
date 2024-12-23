package com.sas.usermanagementservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Session extends BaseModel{

    private String token;
    private Date expiringAt;
    @ManyToOne
    private User user;

    private SessionStatus sessionStatus;
}
