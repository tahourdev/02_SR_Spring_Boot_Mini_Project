package com.keanghor.java.miniproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private UUID appUserId;
    private String userName;
    private String email;
    private String password;
    private String level;
    private int xp;
    private String profileImage;
    private boolean isVerified;
    private LocalDateTime createdAt;

}
