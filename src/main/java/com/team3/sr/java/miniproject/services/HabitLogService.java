package com.team3.sr.java.miniproject.services;

import com.team3.sr.java.miniproject.DTO.HabitLogDTO;
import com.team3.sr.java.miniproject.model.entity.HabitLog;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.UUID;

public interface HabitLogService {
    List<HabitLogDTO> getHabitLogsById(Integer offset, Integer limit, UUID habitId);
//    HabitLogDTO createHabitLog(HabitLogDTO habitLogDTO);
}
