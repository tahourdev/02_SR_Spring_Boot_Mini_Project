package com.team3.sr.java.miniproject.DTO;

import com.team3.sr.java.miniproject.model.enumeration.HabitStatus;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class HabitLogRequestDTO {
    private HabitStatus status;
    private UUID habitId;
}
