package com.keanghor.java.miniproject.model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keanghor.java.miniproject.model.dto.Response.AppUserResponse;
import com.keanghor.java.miniproject.model.enumaration.Frequency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habit {
    private UUID habitId;
    private String title;
    private String description;
    private Frequency frequency;
    private Boolean isActive;
    private AppUserResponse appUserResponse;

    private LocalDateTime createdAt;
}