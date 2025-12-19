package com.example.demo.service;
import com.example.demo.entity.UserProfile;


public interface UserProfileService
{
    UserProfile createUserProfile(UserProfile profile);
    UserProfile getUserById(Long id);

}   