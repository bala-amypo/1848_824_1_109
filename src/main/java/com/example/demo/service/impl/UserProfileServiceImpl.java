package com.example.demo.service.impl;
import 

@Service
public class UserProfileServiceImpl implements UserProfileService{

@Autowired
UserProfileRepository upr;
public UserProfile createUser(UserProfile profile){

return upr.save(profile);
}

}

    
