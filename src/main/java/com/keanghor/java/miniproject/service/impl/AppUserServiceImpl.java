package com.keanghor.java.miniproject.service.impl;

import com.keanghor.java.miniproject.model.entity.AppUser;


import com.keanghor.java.miniproject.model.request.AppUserRequest;
import com.keanghor.java.miniproject.model.response.AppUserResponse;
import com.keanghor.java.miniproject.repository.AppUserRepository;
import com.keanghor.java.miniproject.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String identity) throws UsernameNotFoundException {
        if (identity.contains("@")) return appUserRepository.getUserByEmail(identity);
        return appUserRepository.getUserByUsername(identity);
    }

    @Override
    public AppUserResponse register(AppUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        AppUser appUser = appUserRepository.register(request);
        return modelMapper.map(appUserRepository.getUserById(appUser.getAppUserId()), AppUserResponse.class);
    }
}
