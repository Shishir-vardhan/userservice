package com.sas.usermanagementservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {

    private String email;
    private String password;
}
