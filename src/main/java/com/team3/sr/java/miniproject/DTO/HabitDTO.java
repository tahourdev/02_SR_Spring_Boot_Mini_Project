package com.team3.sr.java.miniproject.DTO;

import com.team3.sr.java.miniproject.DTO.response.AppUserResponse;
import com.team3.sr.java.miniproject.model.enumeration.HabitFrequency;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class HabitDTO {
    private UUID habitId;
    private String title;
    private String description;
    private HabitFrequency frequency;
    private Boolean isActive;
    AppUserResponse appUserResponse;
    private LocalDateTime createdAt;
}