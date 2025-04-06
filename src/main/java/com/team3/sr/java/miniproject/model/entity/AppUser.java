package com.team3.sr.java.miniproject.model.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser {
    private UUID userId;
    private String username;
    private String email;
    private String password;
    private Integer level;
    private Long xp;
    private String profileImage;
    private Boolean isVerified;
    private LocalDateTime createdAt;
}
