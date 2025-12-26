package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserProfileService userProfileService;
    private final UserProfileRepository userProfileRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(
            UserProfileService userProfileService,
            UserProfileRepository userProfileRepository,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil) {

        this.userProfileService = userProfileService;
        this.userProfileRepository = userProfileRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public String login(String userId, String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userId, password)
        );

        return jwtUtil.generateToken(userId);
    }
}
