package com.sas.usermanagementservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends BaseModel {

    @Column(unique = true)
    private String email;
    private String password;
//    private Set<Role> roles = new HashSet<>();

}
