package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.ApiResponse.ApiResponse;
import com.keanghor.java.miniproject.model.entity.Profile;
import com.keanghor.java.miniproject.model.entity.request.ProfileRequest;
import com.keanghor.java.miniproject.services.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    @Operation(summary = "Get current user profile")
    public ResponseEntity<ApiResponse<Profile>> getProfile() {
        ApiResponse<Profile> response = ApiResponse.<Profile>builder()
                .success(true)
                .message("User profile fetch successfully")
                .status(HttpStatus.OK)
                .payload(profileService.getProfile())
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{user-id}")
    @Operation(summary = "Update profile")
    public ResponseEntity<ApiResponse<Profile>> updateProfile(@PathVariable("user-id") UUID userId, @RequestBody ProfileRequest request) {
        Profile profile = profileService.updateProfile(userId, request);
        ApiResponse<Profile> response = ApiResponse.<Profile>builder()
                .success(true)
                .message("User profile Updated successfully")
                .status(HttpStatus.OK)
                .payload(profile)
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{user-id}")
    @Operation(summary = "Delete current user profile")
    public ResponseEntity<ApiResponse<Profile>> deleteProfile(@PathVariable("user-id") UUID userId) {
        profileService.deleteProfile(userId);
        ApiResponse<Profile> response = ApiResponse.<Profile>builder()
                .success(true)
                .message("User profile fetch successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
