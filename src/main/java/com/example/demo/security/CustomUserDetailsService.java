package com.example.demo.security;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;

    public CustomUserDetailsService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId)
            throws UsernameNotFoundException {

        UserProfile user = userProfileRepository
                .findByUserId(userId)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        
        if (!Boolean.TRUE.equals(user.getActive())) {
            throw new UsernameNotFoundException("User is inactive");
        }

        return User.builder()
                .username(user.getUserId())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
