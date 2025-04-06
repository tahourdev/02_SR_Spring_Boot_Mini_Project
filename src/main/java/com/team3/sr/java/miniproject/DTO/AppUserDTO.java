package com.team3.sr.java.miniproject.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class AppUserDTO {
    private UUID appUserId;
    private String username;
    private String email;
    private Integer level;
    private Long xp;
    private String profileImageUrl;
    private Boolean isVerified;
    private LocalDateTime createdAt;
}
