package com.example.demo.service.impl;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService{

@Autowired
UserProfileRepository upr;
public UserProfile createUserProfile(UserProfile profile){
return upr.save(profile);
}

public UserProfile getUserById(Long id){
    return upr.getById(id);
}

public UserProfile findByUserId(String userId){
    return upr.findByUserId(userId).orElse(null);
}
public List<UserProfile> getAllUsers(){
    return upr.findAll();
}
public UserProfile updateUserStatus(Long id,boolean active){
    UserProfile user=
}

}

    
