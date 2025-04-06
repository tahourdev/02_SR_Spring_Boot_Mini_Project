package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.model.entity.AppUser;
import com.keanghor.java.miniproject.model.entity.Profile;
import com.keanghor.java.miniproject.model.request.ProfileRequest;
import com.keanghor.java.miniproject.model.response.APIResponse;
import com.keanghor.java.miniproject.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    @Operation(summary = "Get current user profile")
    public ResponseEntity<APIResponse<Profile>> getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser currentUser = (AppUser) authentication.getPrincipal();
        UUID currentUserId = currentUser.getAppUserId();

        APIResponse<Profile> response = APIResponse.<Profile>builder()
                .success(true)
                .message("User profile fetched successfully")
                .status(HttpStatus.OK)
                .payload(profileService.getProfile(currentUserId)) // 👈 You must pass the user ID here
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{user-id}")
    @Operation(summary = "Update profile")
    public ResponseEntity<APIResponse<Profile>> updateProfile(@PathVariable("user-id") UUID userId, @RequestBody ProfileRequest request) {
        Profile profile = profileService.updateProfile(userId, request);
        APIResponse<Profile> response = APIResponse.<Profile>builder()
                .success(true)
                .message("User profile Updated successfully")
                .status(HttpStatus.OK)
                .payload(profile)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{user-id}")
    @Operation(summary = "Delete current user profile")
    public ResponseEntity<APIResponse<Profile>> deleteProfile(@PathVariable("user-id") UUID userId) {
        profileService.deleteProfile(userId);
        APIResponse<Profile> response = APIResponse.<Profile>builder()
                .success(true)
                .message("User profile fetch successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
