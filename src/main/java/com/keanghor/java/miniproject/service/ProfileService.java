package com.keanghor.java.miniproject.service;

import com.keanghor.java.miniproject.model.entity.Profile;
import com.keanghor.java.miniproject.model.request.ProfileRequest;

import java.util.UUID;

public interface ProfileService {
    Profile getProfile(UUID currentUserId);

    Profile updateProfile(UUID userId, ProfileRequest request);

    void deleteProfile(UUID userId);
}
