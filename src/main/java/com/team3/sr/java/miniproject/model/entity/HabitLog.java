package com.team3.sr.java.miniproject.model.entity;
import com.team3.sr.java.miniproject.model.enumeration.HabitStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitLog {
    private UUID logId;
    private LocalDate logDate;
    private String status;
    private Long xpEarned;
    private UUID habitId;
    private Habit habit;
}
