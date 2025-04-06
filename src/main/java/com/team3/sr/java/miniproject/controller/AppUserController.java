package com.team3.sr.java.miniproject.controller;

import com.team3.sr.java.miniproject.ApiResponse.ApiResponse;
import com.team3.sr.java.miniproject.DTO.AppUserDTO;
import com.team3.sr.java.miniproject.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<ApiResponse<AppUserDTO>> getAppUserById() {
        AppUserDTO appUserDTO = appUserService.getAppUser();
        ApiResponse<AppUserDTO> response = ApiResponse.<AppUserDTO>builder()
                .success(true)
                .message("User profile fetched successfully!")
                .status(HttpStatus.OK)
                .payload(appUserDTO)
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
