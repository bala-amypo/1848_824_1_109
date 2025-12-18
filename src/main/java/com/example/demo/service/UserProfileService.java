package com.example.demo.service;



public interface UserProfileService
{
    UserProfile createUser(UserProfile profile);
    Long getUserById(Long id);

}