package com.keanghor.java.miniproject.service;

import com.keanghor.java.miniproject.model.request.AppUserRequest;
import com.keanghor.java.miniproject.model.response.AppUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {

    AppUserResponse register(AppUserRequest request);
}
