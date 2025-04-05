package com.team3.sr.java.miniproject.model.entity;

import com.team3.sr.java.miniproject.model.enumeration.HabitStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitLog {
    private UUID habitLogId;
    private LocalDateTime logDate;
    private HabitStatus habitStatus;
    private Integer xpEarned;
    private Habit habit;
}
