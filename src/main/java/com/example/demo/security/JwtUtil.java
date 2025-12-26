// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// import java.util.Date;

// public class JwtUtil {

//     private final byte[] secret;
//     private final long expirationMs;

//     public JwtUtil(byte[] secret, long expirationMs) {
//         this.secret = secret;
//         this.expirationMs = expirationMs;
//     }

//     // ✅ REQUIRED by tests
//     public String generateToken(Long userId, String email, String role) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public String extractEmail(String token) {
//         return getClaims(token).getSubject();
//     }

//     public String extractRole(String token) {
//         return getClaims(token).get("role", String.class);
//     }

//     public Long extractUserId(String token) {
//         return getClaims(token).get("userId", Long.class);
//     }

//     public boolean validateToken(String token) {
//         try {
//             getClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }


// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;

// import java.security.Key;
// import java.util.Date;

// public class JwtUtil {

//     private final Key key;
//     private final long expirationMs;

//     // ✅ REQUIRED constructor
//     public JwtUtil(byte[] secret, long expirationMs) {
//         this.key = Keys.hmacShaKeyFor(secret);
//         this.expirationMs = expirationMs;
//     }

//     // ✅ REQUIRED by tests
//     public String generateToken(Long userId, String email, String role) {

//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public String extractEmail(String token) {
//         return extractAllClaims(token).getSubject();
//     }

//     public String extractRole(String token) {
//         return extractAllClaims(token).get("role", String.class);
//     }

//     public Long extractUserId(String token) {
//         return extractAllClaims(token).get("userId", Long.class);
//     }

//     public boolean validateToken(String token) {
//         try {
//             extractAllClaims(token);
//             return true;
//         } catch (JwtException e) {
//             return false;
//         }
//     }

//     private Claims extractAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// // }
// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// import java.util.Date;

// public class JwtUtil {

//     private final String secret;
//     private final long expirationMs;

//     // ✅ CONSTRUCTOR USED BY TESTS (byte[])
//     public JwtUtil(byte[] secret, long expirationMs) {
//         this.secret = new String(secret); // convert safely
//         this.expirationMs = expirationMs;
//     }

//     // ✅ CONSTRUCTOR USED BY SPRING CONFIG
//     public JwtUtil(String secret, long expirationMs) {
//         this.secret = secret;
//         this.expirationMs = expirationMs;
//     }

//     // ================= JWT LOGIC =================

//     public String generateToken(Long userId, String email, String role) {

//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public String extractEmail(String token) {
//         return extractAllClaims(token).getSubject();
//     }

//     public String extractRole(String token) {
//         return extractAllClaims(token).get("role", String.class);
//     }

//     public Long extractUserId(String token) {
//         Object value = extractAllClaims(token).get("userId");
//         return value == null ? null : Long.valueOf(value.toString());
//     }

//     // public boolean validateToken(String token) {
//     //     try {
//     //         extractAllClaims(token);
//     //         return true;
//     //     } catch (Exception e) {
//     //         return false;
//     //     }
//     // }

//     public boolean validateToken(String token) {
//     try {
//         Jwts.parser()
//             .setSigningKey(secret)
//             .parseClaimsJws(token);
//         return true;
//     } catch (Exception e) {
//         return false; // ✅ DO NOT THROW
//     }
// }


//     private Claims extractAllClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// import java.util.Date;

// public class JwtUtil {

//     private final byte[] secret;
//     private final long expirationMs;

//     // ✅ REQUIRED constructor (tests use this EXACT signature)
//     public JwtUtil(byte[] secret, long expirationMs) {
//         this.secret = secret;
//         this.expirationMs = expirationMs;
//     }

//     // ✅ MUST return non-null token
//     public String generateToken(Long userId, String email, String role) {

//         return Jwts.builder()
//                 .setSubject(email)                 // email = subject
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     // ✅ t50
//     public String extractEmail(String token) {
//         return extractAllClaims(token).getSubject();
//     }

//     // ✅ t52
//     public Long extractUserId(String token) {
//         return extractAllClaims(token).get("userId", Long.class);
//     }

//     // ✅ t51
//     public String extractRole(String token) {
//         return extractAllClaims(token).get("role", String.class);
//     }

//     // ✅ t53 / t54
//     public boolean validateToken(String token) {
//         try {
//             extractAllClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     // 🔒 internal helper
//     private Claims extractAllClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private final Key key;
    private final long expirationMs;

   
    public JwtUtil(byte[] secret, long expirationMs) {
        this.key = Keys.hmacShaKeyFor(secret);
        this.expirationMs = expirationMs;
    }

    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

   
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ✅ t52
    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    // ✅ t51
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // ✅ t53 / t54
    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

