package com.sas.usermanagementservice.dto;

import com.sas.usermanagementservice.models.Role;
import com.sas.usermanagementservice.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private String email;
    private String password;
//    private Set<Role> roles = new HashSet<>();

    public static UserDto createUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
