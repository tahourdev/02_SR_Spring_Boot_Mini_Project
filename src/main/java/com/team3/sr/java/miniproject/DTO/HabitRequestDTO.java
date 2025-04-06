package com.team3.sr.java.miniproject.DTO;

import com.team3.sr.java.miniproject.model.enumeration.HabitFrequency;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HabitRequestDTO {
    private String title;
    private String description;
    private HabitFrequency frequency;
}
