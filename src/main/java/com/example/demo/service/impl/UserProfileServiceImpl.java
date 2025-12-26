// package com.example.demo.service.impl;
// import com.example.demo.repository.UserProfileRepository;
// import com.example.demo.entity.UserProfile;
// import com.example.demo.service.UserProfileService;
// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import java.util.List;

// @Service
// public class UserProfileServiceImpl implements UserProfileService{

// @Autowired
// UserProfileRepository upr;

// @Override
// public UserProfile createUser(UserProfile profile){
// return upr.save(profile);
// }
// @Override
// public UserProfile getUserById(Long id){
//     return upr.findById(id).orElse(null);
// }
// @Override
// public UserProfile findByUserId(String userId){
//     return upr.findByUserId(userId).orElse(null);
// }
// @Override
// public List<UserProfile> getAllUsers(){
//     return upr.findAll();
// }
// @Override
// public UserProfile updateUserStatus(Long id,Boolean active){
//     UserProfile user=upr.findById(id).orElse(null);

//     if(user!=null){
//         user.setActive(active);
//         return upr.save(user);
//     }
//     return null;
// }

// }

public UserProfileServiceImpl(
        UserProfileRepository userProfileRepository,
        PasswordEncoder passwordEncoder) {

    this.userProfileRepository = userProfileRepository;
    this.passwordEncoder = passwordEncoder;
}

    
