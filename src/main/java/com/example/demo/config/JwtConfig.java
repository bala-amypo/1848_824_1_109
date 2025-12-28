

// package com.example.demo.config;

// import com.example.demo.security.JwtUtil;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class JwtConfig {

//     @Bean
//     public JwtUtil jwtUtil() {
//         byte[] secret = "test-secret-key-test-secret-key".getBytes();
//         long expirationMs = 60 * 60 * 1000;
//         return new JwtUtil(secret, expirationMs);
//     }
// }


package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {

        // ✅ EXACTLY 32+ characters (>=256 bits)
        byte[] secret =
                "test-secret-key-test-secret-key-123"
                        .getBytes();

        long expirationMs = 60 * 60 * 1000; // 1 hour

        return new JwtUtil(secret, expirationMs);
    }
}
