package com.team3.sr.java.miniproject.DTO.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppUserResponse {
    private UUID appUserId;
    private String username;
    private String email;
    private Integer level;
    private Long xp;
    private String profileImageUrl;
    private Boolean isVerified;
    private LocalDateTime createdAt;
}
