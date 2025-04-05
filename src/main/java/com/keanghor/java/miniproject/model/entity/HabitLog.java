package com.keanghor.java.miniproject.model.entity;

import com.keanghor.java.miniproject.model.enumeration.HabitStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

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
