package com.keanghor.java.miniproject.service;

import com.keanghor.java.miniproject.model.entity.request.AppUserRequest;
import com.keanghor.java.miniproject.model.entity.response.AppUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {

    AppUserResponse register(AppUserRequest request);
}
