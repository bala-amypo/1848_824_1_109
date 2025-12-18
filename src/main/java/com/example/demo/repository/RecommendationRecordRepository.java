package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long>{
    
}