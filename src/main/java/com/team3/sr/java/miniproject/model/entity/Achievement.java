package com.team3.sr.java.miniproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    private UUID achievementId;
    private String achievementTitle;
    private String description;
    private String achievementBadge;
    private Long xpRequired;
}
