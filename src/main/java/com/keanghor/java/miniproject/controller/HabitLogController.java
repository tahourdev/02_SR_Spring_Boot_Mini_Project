//package com.keanghor.java.miniproject.controller;
//
//import com.keanghor.java.miniproject.model.entity.HabitLog;
//import com.keanghor.java.miniproject.model.response.APIResponse;
//
//import com.keanghor.java.miniproject.service.HabitLogService;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Positive;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/v1/habit-logs")
//@RequiredArgsConstructor
//public class HabitLogController {
//    private final HabitLogService habitLogService;
//
//    @GetMapping("/{habitId}")
//    public ResponseEntity<APIResponse<List<HabitLog>>> getHabitLogsByHabitId(
//            @PathVariable UUID habitId,
//            @RequestParam(required = false, defaultValue = "1") @Positive(message = "Offset must be greater than 0!!!") @NotNull(message = "Offset is required!!!") Integer offset,
//            @RequestParam(required = false, defaultValue = "10") @Positive(message = "Limit must be greater than 0!!!") @NotNull(message = "Limit is required!!!") Integer limit) {
//        List<HabitLog> habitLogDTOs = habitLogService.getHabitLogsByHabitId(habitId, offset, limit);
//        APIResponse<List<HabitLog>> response = APIResponse.<List<HabitLog>>builder()
//                .success(true)
//                .message("Fetched all habit logs for the specified habit ID successfully!")
//                .status(HttpStatus.OK)
//                .payload(habitLogDTOs)
//                .instant(Instant.now())
//                .build();
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
////    @PostMapping
////    public ResponseEntity<APIResponse<HabitLog>> createHabitLog(@RequestBody HabitLogRequestDTO habitLogRequestDTO) {
////        HabitLogDTO createdHabitLogDTO = habitLogService.createHabitLog(habitLogRequestDTO);
////        ApiResponse<HabitLogDTO> response = ApiResponse.<HabitLogDTO>builder()
////                .success(true)
////                .message("Habit log created successfully!")
////                .status(HttpStatus.CREATED)
////                .payload(createdHabitLogDTO)
////                .timestamps(LocalDateTime.now())
////                .build();
////        return ResponseEntity.status(HttpStatus.CREATED).body(response);
////    }
//}
