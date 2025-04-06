package com.team3.sr.java.miniproject.DTO;

import com.team3.sr.java.miniproject.model.enumeration.HabitStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class HabitLogDTO {
    private UUID habitLogId; // Renamed from logId
    private LocalDate logDate;
    private HabitStatus status; // Matches "status": "COMPLETED"
    private Long xpEarned;
    private HabitDTO habit; // Nested HabitDTO
}
