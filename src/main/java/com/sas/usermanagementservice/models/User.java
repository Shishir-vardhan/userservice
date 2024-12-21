package com.sas.usermanagementservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends BaseModel {

    private String email;
    private String password;
//    private Set<Role> roles = new HashSet<>();

}
