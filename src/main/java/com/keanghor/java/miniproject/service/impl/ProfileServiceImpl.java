package com.keanghor.java.miniproject.service.impl;

import com.keanghor.java.miniproject.exception.NotFoundException;
import com.keanghor.java.miniproject.model.entity.Profile;
import com.keanghor.java.miniproject.model.request.ProfileRequest;
import com.keanghor.java.miniproject.repository.ProfileRepository;
import com.keanghor.java.miniproject.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    @Override
    public Profile getProfile(UUID currentUserId) {

        Profile profile = profileRepository.getUserProfile(currentUserId);
        if (profile == null) {
            throw new NotFoundException("Profile not found. Please Login or Register first!");
        }
        return profile;
    }

    @Override
    public Profile updateProfile(UUID userId, ProfileRequest request) {
        Profile existingProfile = profileRepository.getProfileByUserId(userId);
        if (existingProfile == null) {
            throw new NotFoundException("User not found for update. Please Login or Register first!");
        }
        return profileRepository.updateProfile(userId, request);
    }

    @Override
    public void deleteProfile(UUID userId) {
        Profile existingProfile = profileRepository.getProfileByUserId(userId);
        if (existingProfile == null) {
            throw new NotFoundException("User not found for deletion.");
        }
        profileRepository.deleteProfile(userId);
    }


}
