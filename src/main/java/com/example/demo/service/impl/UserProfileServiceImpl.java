package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ REQUIRED constructor (USED BY TESTS)
    public UserProfileServiceImpl(
            UserProfileRepository userProfileRepository,
            PasswordEncoder passwordEncoder) {

        this.userProfileRepository = userProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserProfile createUser(UserProfile profile) {
        // Test expects password to be encoded
        if (profile.getPassword() != null) {
            profile.setPassword(
                    passwordEncoder.encode(profile.getPassword()));
        }
        return userProfileRepository.save(profile);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    @Override
    public UserProfile findByUserId(String userId) {
        return userProfileRepository.findByUserId(userId).orElse(null);
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

@Override
public UserProfile updateUserStatus(Long id, Boolean active) {
    UserProfile user = userProfileRepository.findById(id).orElse(null);
    if (user != null) {
        user.setActive(active);
        return userProfileRepository.save(user);
    }
    return null;
}

}
