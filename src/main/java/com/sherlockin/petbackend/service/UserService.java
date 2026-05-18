package com.sherlockin.petbackend.service;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sherlockin.petbackend.model.User;
import com.sherlockin.petbackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User registerUser(String email, String document, String firstName, String lastName, String password, String phone, String address) {
        return userRepository.save(new User(
            document,
            email,
            phone,
            passwordEncoder.encode(password),
            firstName,
            lastName,
            address
        ));
        
    }

}
