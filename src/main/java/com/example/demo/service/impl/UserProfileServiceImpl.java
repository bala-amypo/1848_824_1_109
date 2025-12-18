package com.example.demo.service.impl;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserProfileServiceImpl implements UserProfileService{

@Autowired
UserProfileRepository upr;
public UserProfile createUser(UserProfile profile){

return upr.save(profile);
}

}

    
