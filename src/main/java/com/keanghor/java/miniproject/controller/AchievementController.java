package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.model.entity.Achievement;
import com.keanghor.java.miniproject.model.entity.AppUser;
import com.keanghor.java.miniproject.model.response.APIResponse;
import com.keanghor.java.miniproject.service.AchievementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/achievements")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class AchievementController {
    //Inject service
    private final AchievementService achievementService;

    //Endpoint get all achievements
    @GetMapping
    @Operation(summary = "Get all Achievements")
    public ResponseEntity<APIResponse<List<Achievement>>> getAllAchievements(@RequestParam(defaultValue = "1") Integer page,
                                                                             @RequestParam(defaultValue = "10") Integer size) {
        List<Achievement> achievements = achievementService.getAllAchievements(page, size);
        APIResponse<List<Achievement>> response = APIResponse.<List<Achievement>>builder()
                .success(true)
                .message("All Achievements have been Fetch successfully!")
                .status(HttpStatus.OK)
                .payload(achievements)
                .instant(Instant.now())
                .build();
        ;
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Endpoint get all achievements by App user Id(current user)
    @GetMapping("/app-users")
    @Operation(summary = "Get all Achievements By User ID")
    public ResponseEntity<APIResponse<List<Achievement>>> getAchievementByCurrentUser(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        AppUser currentUser = (AppUser) authentication.getPrincipal();

        UUID currentUserId = currentUser.getAppUserId();

        String username = currentUser.getUsername();

        List<Achievement> achievements = achievementService.getAchievementByUserId(page, size, currentUserId);

        APIResponse<List<Achievement>> response = APIResponse.<List<Achievement>>builder()
                .success(true)
                .message("Achievements for <" + username + "> have been fetched successfully!")
                .status(HttpStatus.OK)
                .payload(achievements)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
