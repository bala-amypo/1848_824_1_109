package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserProfileController{
    @Autowired
    UserProfileService ups;
    @PostMapping("/UserProfile")
    public UserProfile addUserProfile(@RequestBody UserProfile profile ){
        return ups.createUserProfile(profile);
    }

    //@GetMapping("/{id}")
     //public UserProfile getId(@PathVariable Long id){
        //return ups.getUserById(id);
    //}

    @GetMapping("/{userId}")
    public UserProfile getUser(@PathVariable String userId){
        return ups.findByUserId(userId);
    }
    @GetMapping
    public List<UserProfile> getAllUsers(){
        return ups.getAllUsers();
    }
    
    @PutMapping("/status")
    public UserProfile updateStatus(@PathVariable Long id,@RequestParam Boolean active){
        return ups.updateUserStatus(id,active);
    }    
    

    
}