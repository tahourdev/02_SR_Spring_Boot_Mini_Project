package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.model.Entity.Habit;
import com.keanghor.java.miniproject.model.dto.Request.HabitRequest;
import com.keanghor.java.miniproject.model.dto.Response.ApiResponse;
import com.keanghor.java.miniproject.model.dto.Response.AppUserResponse;
import com.keanghor.java.miniproject.repository.HabitRepository;
import com.keanghor.java.miniproject.service.HabitService;
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

    private final HabitRepository habitRepository;

    public HabitController(HabitService habitService, HabitRepository habitRepository) {
        this.habitService = habitService;
        this.habitRepository = habitRepository;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Habit>>> getAllAuthors(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        List<Habit> habits = habitService.getAllHabits(page, size);
        ApiResponse<List<Habit>> response = ApiResponse.<List<Habit>>builder()
                .success(true)
                .message("Get all Habits successful!")
                .status(HttpStatus.OK)
                .payload(habits)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Habit>> createHabit(@RequestBody HabitRequest request){
        Habit habit = habitService.createHabit(request);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .success(true)
                .message("Habit created successfully!")
                .status(HttpStatus.CREATED)
                .payload(habit)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{habit-id}")
    public ResponseEntity<ApiResponse<Habit>> deleteHabitById(@PathVariable("habit-id") UUID habitId){
        habitService.deleteHabitById(habitId);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .success(true)
                .message("Delete Habit by" +habitId+"successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{habit-id}")
    public ResponseEntity<ApiResponse<Habit>> updateHabitById(@PathVariable("habit-id") UUID habitId,@RequestBody HabitRequest request){
        Habit habit = habitService.updateHabitById(habitId,request);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .success(true)
                .message("Update habit by" +habitId+"successfully!")
                .status(HttpStatus.OK)
                .payload(habit)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{habit-id}")
    public ResponseEntity<ApiResponse<Habit>> getHabitById(@PathVariable("habit-id") UUID habitId){
        Habit habit = habitService.getHabitById(habitId);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .success(true)
                .message("Get author by " + habitId + " successful!")
                .status(HttpStatus.OK)
                .payload(habit)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}



