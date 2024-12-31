package com.socialmedia.app.SocialMediaApp.Jwt;

import com.socialmedia.app.SocialMediaApp.Entities.User;
import com.socialmedia.app.SocialMediaApp.Exceptions.ResourceNotFoundException;
import com.socialmedia.app.SocialMediaApp.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User foundUser = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("user", "username", 0));
        if (foundUser.getUsername().equals(username)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(foundUser.getUsername())
                    .password(foundUser.getPassword())
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
