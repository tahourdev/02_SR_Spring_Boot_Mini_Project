package com.keanghor.java.miniproject.model.entity;

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
