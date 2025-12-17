package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
@Entity
public class UserProfile{
    @Id
    private Long id;
    @Column(unique=true)
    private String userId;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;
    private Boolean active;
    private LocalDateTime createdAt;

    
}