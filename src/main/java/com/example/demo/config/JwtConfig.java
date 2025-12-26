package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {

        // ✅ MUST BE STRING (old jjwt compatibility)
        String secret = "my-secret-key-my-secret-key-123456";

        long expirationMs = 24 * 60 * 60 * 1000; // 1 day

        return new JwtUtil(secret, expirationMs);
    }
}
