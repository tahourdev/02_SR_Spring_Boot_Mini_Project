package com.keanghor.java.miniproject.service.impl;

import com.keanghor.java.miniproject.model.entity.Achievement;
import com.keanghor.java.miniproject.repository.AchievementRepository;
import com.keanghor.java.miniproject.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository achievementRepository;

    @Override
    public List<Achievement> getAllAchievement(Integer offset, Integer size) {
        return achievementRepository.getAllAchievement(offset, size);
    }

    @Override
    public List<Achievement> getAchievementByUserId(Integer offset, Integer size,Long userId) {
        return achievementRepository.getAchievementByUserId(offset, size,userId);
    }
}
