package com.team3.sr.java.miniproject.services.serviceImp;

import com.team3.sr.java.miniproject.DTO.AchievementDTO;
import com.team3.sr.java.miniproject.mapper.AchievementMapperDTO;
import com.team3.sr.java.miniproject.model.entity.Achievement;
import com.team3.sr.java.miniproject.repository.AchievementRepository;
import com.team3.sr.java.miniproject.repository.AppUserAchievementRepository;
import com.team3.sr.java.miniproject.services.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;
    private final AchievementMapperDTO achievementMapperDTO;

    @Override
    public List<AchievementDTO> getAchievements(Integer offset, Integer limit) {
        offset = (offset - 1) * limit;
        List<Achievement> achievements = achievementRepository.findAll(offset, limit);
        return achievements.stream()
                .map(achievementMapperDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void checkAndAwardAchievements(UUID appUserId, Long newXp) {

    }
}
