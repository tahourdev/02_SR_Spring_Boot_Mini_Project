package com.keanghor.java.miniproject.model.dto.Request;

import com.keanghor.java.miniproject.model.dto.Response.AppUserResponse;
import com.keanghor.java.miniproject.model.enumaration.Frequency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitRequest {
    private String title;
    private String description;
    private Frequency frequency;
//    private Boolean isActive;
//    private AppUserResponse appUserResponse;
//    private LocalDateTime createdAt;
}
