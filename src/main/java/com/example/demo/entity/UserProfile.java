package com.example.demo.entity;
import jakarta.persistence.Entity;
@Entity
public class UserProfile{
    @Id
    private Long id;
    @column(unique=true)
    private String userId;
    private String fullName;
    @column(unique=true)
    private String email;
}