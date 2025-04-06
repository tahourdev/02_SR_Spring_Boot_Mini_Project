package com.keanghor.java.miniproject.model.entity;

import com.keanghor.java.miniproject.model.enumaration.HabitStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitLog {
    private Integer habitLogId;
    private LocalDateTime logDate;
    private HabitStatus status;
    private Integer xpEarned;
    private Habit habit;
}
