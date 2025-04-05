package com.keanghor.java.miniproject.service;

import com.keanghor.java.miniproject.model.entity.Achievement;

import java.util.List;
import java.util.UUID;

public interface AchievementService {
    List<Achievement> getAllAchievements(Integer page, Integer size);

    List<Achievement> getAchievementByUserId(Integer page, Integer size, UUID userId);
}
