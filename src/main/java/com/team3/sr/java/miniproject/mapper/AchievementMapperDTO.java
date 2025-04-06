package com.team3.sr.java.miniproject.mapper;

import com.team3.sr.java.miniproject.DTO.AchievementDTO;
import com.team3.sr.java.miniproject.model.entity.Achievement;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface AchievementMapperDTO {

    AchievementDTO toDTO(Achievement achievement);

    Achievement toEntity(AchievementDTO achievementDTO);
}
