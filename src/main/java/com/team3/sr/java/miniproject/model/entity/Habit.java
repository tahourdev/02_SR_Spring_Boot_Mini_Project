package com.team3.sr.java.miniproject.model.entity;

import com.team3.sr.java.miniproject.model.enumeration.HabitFrequency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
