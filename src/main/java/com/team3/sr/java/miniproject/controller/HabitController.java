package com.team3.sr.java.miniproject.controller;

import com.team3.sr.java.miniproject.ApiResponse.ApiResponse;
import com.team3.sr.java.miniproject.model.entity.Habit;
import com.team3.sr.java.miniproject.services.HabitService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/habits")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Habit>>> getHabits(
            @RequestParam(required = false, defaultValue = "1") @Positive(message = "Offset must be greater than 0!!!") @NotNull(message = "Offset is required!!!") Integer offset,
            @RequestParam(required = false, defaultValue = "10") @Positive(message = "Limit must be greater than 0!!!") @NotNull(message = "Limit is required!!!") Integer limit) {
        List<Habit> habitDTOs = habitService.getHabits( offset, limit);
        ApiResponse<List<Habit>> response = ApiResponse.<List<Habit>>builder()
                .success(true)
                .message("Fetched all habits successfully!")
                .status(HttpStatus.OK)
                .payload(habitDTOs)
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

//    @PostMapping("/{appUserId}")
//    public ResponseEntity<ApiResponse<HabitDTO>> createHabit(
//            @PathVariable UUID appUserId,
//            @RequestBody HabitRequestDTO habitRequestDTO) {
//        HabitDTO createdHabitDTO = habitService.createHabit(habitRequestDTO, appUserId);
//        ApiResponse<HabitDTO> response = ApiResponse.<HabitDTO>builder()
//                .success(true)
//                .message("string")
//                .status("100 CONTINUE")
//                .payload(createdHabitDTO)
//                .timestamps(LocalDateTime.now())
//                .build();
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
}
