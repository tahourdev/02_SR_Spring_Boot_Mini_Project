package com.team3.sr.java.miniproject.services;

import com.team3.sr.java.miniproject.DTO.AchievementDTO;

import java.util.List;
import java.util.UUID;

public interface AchievementService {

    List<AchievementDTO> getAchievements(Integer offset, Integer limit);

    void checkAndAwardAchievements(UUID appUserId, Long newXp);
}
