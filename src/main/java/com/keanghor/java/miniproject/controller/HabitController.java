package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.model.entity.Achievement;
import com.keanghor.java.miniproject.model.entity.AppUser;
import com.keanghor.java.miniproject.model.request.HabitRequest;
import com.keanghor.java.miniproject.model.entity.Habit;
import com.keanghor.java.miniproject.model.response.APIResponse;
import com.keanghor.java.miniproject.service.HabitService;
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
@RequestMapping("/api/v1/habits")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class HabitController {

    private final HabitService habitService;

    //Get all habits by current user
    @GetMapping
    @Operation(summary = "Get All Habits of current user")
    public ResponseEntity<APIResponse<List<Habit>>> getAllHabits(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        AppUser currentUser = (AppUser) authentication.getPrincipal();

        UUID currentUserId = currentUser.getAppUserId();
        List<Habit> habits = habitService.getHabitByUserId(page, size, currentUserId);

//        List<Habit> habits = habitService.getAllHabits(page, size);
        APIResponse<List<Habit>> response = APIResponse.<List<Habit>>builder()
                .success(true)
                .message("Fetched all habits successfully.")
                .status(HttpStatus.OK)
                .payload(habits)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Get a habit of current user by ID
    @GetMapping("/{habit-id}")
    @Operation(summary = "Get a Habit by ID")
    public ResponseEntity<APIResponse<Habit>> getHabitById(@PathVariable("habit-id") UUID habitId) {

        Habit habit = habitService.getHabitById(habitId);
        APIResponse<Habit> response = APIResponse.<Habit>builder()
                .success(true)
                .message("Habit with ID " + habitId + " retrieved successfully.")
                .status(HttpStatus.OK)
                .payload(habit)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Update a habit of current user by ID
    @PutMapping("/{habit-id}")
    @Operation(summary = "Update a Habit by ID")
    public ResponseEntity<APIResponse<Habit>> updateHabitById(
            @PathVariable("habit-id") UUID habitId,
            @RequestBody HabitRequest request) {

        Habit updatedHabit = habitService.updateHabitById(habitId, request);
        APIResponse<Habit> response = APIResponse.<Habit>builder()
                .success(true)
                .message("Habit with ID " + habitId + " updated successfully.")
                .status(HttpStatus.OK)
                .payload(updatedHabit)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Create a habit for current user by ID
    @PostMapping
    @Operation(summary = "Create a new Habit")
    public ResponseEntity<APIResponse<Habit>> createHabit(@RequestBody HabitRequest request) {

        Habit habit = habitService.createHabit(request);
        APIResponse<Habit> response = APIResponse.<Habit>builder()
                .success(true)
                .message("Habit created successfully.")
                .status(HttpStatus.CREATED)
                .payload(habit)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //Delete a habit of current user by ID
    @DeleteMapping("/{habit-id}")
    @Operation(summary = "Delete a Habit by ID")
    public ResponseEntity<APIResponse<Void>> deleteHabitById(@PathVariable("habit-id") UUID habitId) {

        habitService.deleteHabitById(habitId);
        APIResponse<Void> response = APIResponse.<Void>builder()
                .success(true)
                .message("Habit with ID " + habitId + " deleted successfully.")
                .status(HttpStatus.OK)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}



