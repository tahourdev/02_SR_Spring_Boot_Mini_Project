package com.team3.sr.java.miniproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserAchievement {
    private UUID appUserAchievementId;
    private UUID appUserId;
    private UUID achievementId;
    private AppUser appUser;
    private Achievement achievement;
}
