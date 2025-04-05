package com.keanghor.java.miniproject.service;

import com.keanghor.java.miniproject.model.request.AuthRegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {

    void registerUser(AuthRegisterRequest request);
}
