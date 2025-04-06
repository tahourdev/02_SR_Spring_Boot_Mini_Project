package com.keanghor.java.miniproject.service.impl;

import com.keanghor.java.miniproject.exception.NotFoundException;
import com.keanghor.java.miniproject.model.entity.Achievement;
import com.keanghor.java.miniproject.repository.AchievementRepository;
import com.keanghor.java.miniproject.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository achievementRepository;

    @Override
    public List<Achievement> getAllAchievements(Integer page, Integer size) {
        page = (page - 1) * size;
        if (page < 0) {
            throw new InvalidParameterException("Offset must be a non-negative integer.");
        }
        if (size <= 0) {
            throw new InvalidParameterException("Size must be a positive integer.");
        }

        List<Achievement> achievements = achievementRepository.getAllAchievements(page, size);

        if (achievements.isEmpty()) {
            throw new NotFoundException("No achievements found for the given offset and size.");
        }

        return achievements;
    }

    @Override
    public List<Achievement> getAchievementByUserId(Integer page, Integer size, UUID userId) {
        page = (page - 1) * size;
        if (page < 0) {
            throw new InvalidParameterException("Offset must be a non-negative integer.");
        }
        if (size <= 0) {
            throw new InvalidParameterException("Size must be a positive integer.");
        }
        if (userId == null) {
            throw new InvalidParameterException("User ID must be a positive integer.");
        }

        List<Achievement> achievements = achievementRepository.getAchievementByUserId(page, size, userId);

        if (achievements.isEmpty()) {
            throw new NotFoundException("User have no achievements found!!");
        }
        return achievements;
    }

}
