package com.team3.sr.java.miniproject.controller;

import com.team3.sr.java.miniproject.ApiResponse.ApiResponse;
import com.team3.sr.java.miniproject.model.entity.HabitLog;
import com.team3.sr.java.miniproject.services.HabitLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/habit-logs")
@RequiredArgsConstructor
public class HabitLogController {
    private final HabitLogService habitLogService;
    @GetMapping("/{habit-id}")
    public ResponseEntity<ApiResponse<List<HabitLog>>> getHabitLogByHabitId(@PathVariable("habit-id")UUID habitId) {
        ApiResponse<List<HabitLog>> response = ApiResponse.<List<HabitLog>>builder()
                .success(true)
                .message("Fetched all habit logs for the specified habit ID successfully!")
                .status(HttpStatus.OK)
                .payload(habitLogService.getAllHabitLogById())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
