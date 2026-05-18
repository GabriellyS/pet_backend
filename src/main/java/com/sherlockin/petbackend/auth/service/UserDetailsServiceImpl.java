package com.sherlockin.petbackend.auth.service;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.sherlockin.petbackend.auth.model.UserAuthenticated;
import com.sherlockin.petbackend.model.User;
import com.sherlockin.petbackend.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) { 
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);

        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        return new UserAuthenticated(optionalUser.get());
    }

}
