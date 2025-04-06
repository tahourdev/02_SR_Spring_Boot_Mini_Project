package com.keanghor.java.miniproject.model.dto.Request;

import com.keanghor.java.miniproject.model.enumaration.Frequency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitRequest {
    private String title;
    private String description;
    private Frequency frequency;
}
