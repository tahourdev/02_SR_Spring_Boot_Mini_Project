package com.keanghor.java.miniproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Achievement {
    private UUID achievementId;
    private String title;
    private String description;
    private String badge;
    private Long xpRequired;
}
