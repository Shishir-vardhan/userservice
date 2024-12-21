package com.sas.usermanagementservice.services;

import com.sas.usermanagementservice.dto.UserDto;
import com.sas.usermanagementservice.models.User;
import com.sas.usermanagementservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;

    AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDto singUp(String email, String password) {
        User user = new User();
        System.out.println(email);
        System.out.println(password);
        user.setEmail(email);
        user.setPassword(password);

        User savedUser = userRepository.save(user);

        return  UserDto.createUserDto(savedUser);
    }
}
