package com.keanghor.java.miniproject.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Habit {
    private UUID habitId;
    private String habitTitle;
    private HabitFrequency habitFrequency;
    private Boolean isActive;
    private AppUser appUser;
}
