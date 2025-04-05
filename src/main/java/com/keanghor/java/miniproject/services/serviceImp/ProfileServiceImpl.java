package com.keanghor.java.miniproject.services.serviceImp;

import com.keanghor.java.miniproject.ApiResponse.ApiResponse;
import com.keanghor.java.miniproject.model.entity.Profile;
import com.keanghor.java.miniproject.model.entity.request.ProfileRequest;
import com.keanghor.java.miniproject.repository.ProfileRepository;
import com.keanghor.java.miniproject.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    @Override
    public Profile getProfile() {

        return profileRepository.getUserProfile();
    }

    @Override
    public Profile updateProfile(UUID userId, ProfileRequest request) {
        return profileRepository.updateProfile(userId, request);
    }

    @Override
    public void deleteProfile(UUID userId) {
        profileRepository.deleteProfile(userId);
    }


}
