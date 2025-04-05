package com.keanghor.java.miniproject.services;

import com.keanghor.java.miniproject.ApiResponse.ApiResponse;
import com.keanghor.java.miniproject.model.entity.Profile;
import com.keanghor.java.miniproject.model.entity.request.ProfileRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ProfileService {
    Profile getProfile();

    Profile updateProfile(UUID userId, ProfileRequest request);

    void deleteProfile(UUID userId);
}
