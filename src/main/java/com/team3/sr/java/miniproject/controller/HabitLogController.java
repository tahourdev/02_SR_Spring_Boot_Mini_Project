package com.team3.sr.java.miniproject.controller;

import com.team3.sr.java.miniproject.ApiResponse.ApiResponse;
import com.team3.sr.java.miniproject.DTO.HabitLogDTO;
import com.team3.sr.java.miniproject.model.entity.HabitLog;
import com.team3.sr.java.miniproject.services.HabitLogService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/habit-logs")
@RequiredArgsConstructor
public class HabitLogController {
    private final HabitLogService habitLogService;

    @GetMapping("/{habitId}")
    public ResponseEntity<ApiResponse<List<HabitLogDTO>>> getHabitLogsByHabitId(
            @PathVariable UUID habitId,
            @RequestParam(required = false, defaultValue = "1") @Positive(message = "Offset must be greater than 0!!!") @NotNull(message = "Offset is required!!!") Integer offset,
            @RequestParam(required = false, defaultValue = "10") @Positive(message = "Limit must be greater than 0!!!") @NotNull(message = "Limit is required!!!") Integer limit
    ) {
        List<HabitLogDTO> habitLogDTOs = habitLogService.getHabitLogsById(offset, limit, habitId);
        ApiResponse<List<HabitLogDTO>> response = ApiResponse.<List<HabitLogDTO>>builder()
                .success(true)
                .message("Fetched all habit logs for the specified habit ID successfully!")
                .status(HttpStatus.OK)
                .payload(habitLogDTOs)
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
