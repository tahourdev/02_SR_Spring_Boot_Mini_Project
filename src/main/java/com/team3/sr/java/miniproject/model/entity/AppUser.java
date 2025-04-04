package com.team3.sr.java.miniproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private UUID appUserId;
    private String appUserName;
    private String userEmail;
    private Integer userLevel;
    private Long userXp;
    private String userProfileImageUrl;
    private Boolean userIsVerified;
    private LocalDateTime createdAt;
}
