package com.sas.usermanagementservice.services;

import com.sas.usermanagementservice.dto.UserDto;
import com.sas.usermanagementservice.models.Session;
import com.sas.usermanagementservice.models.User;
import com.sas.usermanagementservice.repositories.SessionRepository;
import com.sas.usermanagementservice.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SessionRepository sessionRepository;

    AuthService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.sessionRepository = sessionRepository;
    }


    public UserDto singUp(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        User savedUser = userRepository.save(user);
        return  UserDto.createUserDto(savedUser);
    }

    public ResponseEntity<UserDto> logIn(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isEmpty()) {
            return null;
        }
        User user = userOptional.get();
        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        // To create toke need RandomStringUtils method. For using first we need to add dependency for it.
        String token = RandomStringUtils.randomAlphanumeric(30);

        Session session = new Session();
        session.setToken(token);
        session.setUser(user);
        sessionRepository.save(session);

        UserDto userDto = new UserDto();
        userDto.setEmail(email);

        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userDto, HttpStatus.OK);

        return responseEntity;
    }
}
