package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserProfileController{
    @Autowired
    UserProfileService ups;
    @PostMapping("/UserProfile")
    public UserProfile addUserProfile(@RequestBody UserProfile profile ){
        return ups.createUserProfile(profile);
    }

    @GetMapping("/{id}")
    public UserProfile getUserId(@PathVariable Long id){
        return ups.getUserById(id);
    }
    
}