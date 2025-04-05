package com.keanghor.java.miniproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Achievement {
    private String achievementId;
    private String title;
    private String description;
    private String badge;
    private Long xpRequired;
}
