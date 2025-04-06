package com.keanghor.java.miniproject.service.impl;

import com.keanghor.java.miniproject.model.entity.AppUser;
import com.keanghor.java.miniproject.model.request.AuthRegisterRequest;
import com.keanghor.java.miniproject.repository.AppUserRepository;
import com.keanghor.java.miniproject.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String identity) throws UsernameNotFoundException {
        if (identity.contains("@")) return appUserRepository.getUserByEmail(identity);
        return appUserRepository.getUserByUsername(identity);
    }

//    @Override
//    public void registerUser(AuthRegisterRequest request) {
//        // Check if the email is already registered
//        if (appUserRepository.existsByEmail(request.getEmail())) {
//            throw new RuntimeException("Email is already taken.");
//        }
//
//        // Hash the password using BCrypt
//        String encodedPassword = passwordEncoder.encode(request.getPassword());
//
//        // Create a new AppUser entity and set the values from the request
//        AppUser user = new AppUser();
//        user.setUserName(request.getUsername());
//        user.setEmail(request.getEmail());
//        user.setPassword(encodedPassword);
//
//        // Save the new user to the repository
//        appUserRepository.save(user);
//    }

}
