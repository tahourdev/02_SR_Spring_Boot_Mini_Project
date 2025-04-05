package com.keanghor.java.miniproject.service;

import com.keanghor.java.miniproject.model.entity.Achievement;

import java.util.List;

public interface AchievementService {
    List<Achievement> getAllAchievement(Integer offset, Integer size);

    List<Achievement> getAchievementByUserId(Integer page, Integer size,Long userId);
}
