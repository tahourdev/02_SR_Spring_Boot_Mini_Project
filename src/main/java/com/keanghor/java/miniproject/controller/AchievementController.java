package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.model.entity.Achievement;
import com.keanghor.java.miniproject.model.response.APIResponse;
import com.keanghor.java.miniproject.service.AchievementService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/achievements")
@RequiredArgsConstructor
public class AchievementController {
    //Inject service
    private final AchievementService achievementService;

    //Endpoint get all achievements
    @GetMapping
    @Operation(summary = "Get all Achievements")
    public ResponseEntity<APIResponse<List<Achievement>>> getAllAchievement(Integer page,Integer size) {
        int offset = (page - 1) * size;
        List<Achievement> achievements = achievementService.getAllAchievement(offset, size);
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
    @GetMapping("/{user-id}")
    @Operation(summary = "Get all Achievements By User ID")
    public ResponseEntity<APIResponse<List<Achievement>>> getAchievementByUserId(Integer page, Integer size, @PathVariable("user-id") Long userId) {
        int offset = (page - 1) * size;
        List<Achievement> achievements = achievementService.getAchievementByUserId(offset, size,userId);
        APIResponse<List<Achievement>> response = APIResponse.<List<Achievement>>builder()
                .success(true)
                .message("All Achievements by Current User have been Fetch successfully!")
                .status(HttpStatus.OK)
                .payload(achievements)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
