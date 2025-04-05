package com.keanghor.java.miniproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habit {
    private UUID habitId;
    private String habitTitle;
    private HabitFrequency habitFrequency;
    private Boolean isActive;
    private AppUser appUser;
}
