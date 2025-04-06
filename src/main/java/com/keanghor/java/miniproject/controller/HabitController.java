package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.model.Entity.Habit;
import com.keanghor.java.miniproject.model.dto.Request.HabitRequest;
import com.keanghor.java.miniproject.model.dto.Response.ApiResponse;
import com.keanghor.java.miniproject.repository.HabitRepository;
import com.keanghor.java.miniproject.service.HabitService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService, HabitRepository habitRepository) {
        this.habitService = habitService;
    }

    @GetMapping
    @Operation(summary = "Get All Habits")
    public ResponseEntity<ApiResponse<List<Habit>>> getAllHabits(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        List<Habit> habits = habitService.getAllHabits(page, size);
        ApiResponse<List<Habit>> response = ApiResponse.<List<Habit>>builder()
                .success(true)
                .message("Fetched all habits successfully.")
                .status(HttpStatus.OK)
                .payload(habits)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    @Operation(summary = "Create a new Habit")
    public ResponseEntity<ApiResponse<Habit>> createHabit(@RequestBody HabitRequest request) {

        Habit habit = habitService.createHabit(request);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .success(true)
                .message("Habit created successfully.")
                .status(HttpStatus.CREATED)
                .payload(habit)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{habit-id}")
    @Operation(summary = "Delete a Habit by ID")
    public ResponseEntity<ApiResponse<Void>> deleteHabitById(@PathVariable("habit-id") UUID habitId) {

        habitService.deleteHabitById(habitId);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .message("Habit with ID " + habitId + " deleted successfully.")
                .status(HttpStatus.OK)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{habit-id}")
    @Operation(summary = "Update a Habit by ID")
    public ResponseEntity<ApiResponse<Habit>> updateHabitById(
            @PathVariable("habit-id") UUID habitId,
            @RequestBody HabitRequest request) {

        Habit updatedHabit = habitService.updateHabitById(habitId, request);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .success(true)
                .message("Habit with ID " + habitId + " updated successfully.")
                .status(HttpStatus.OK)
                .payload(updatedHabit)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{habit-id}")
    @Operation(summary = "Get a Habit by ID")
    public ResponseEntity<ApiResponse<Habit>> getHabitById(@PathVariable("habit-id") UUID habitId) {

        Habit habit = habitService.getHabitById(habitId);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .success(true)
                .message("Habit with ID " + habitId + " retrieved successfully.")
                .status(HttpStatus.OK)
                .payload(habit)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
