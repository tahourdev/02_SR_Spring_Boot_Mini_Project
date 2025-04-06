package com.team3.sr.java.miniproject.services;

import com.team3.sr.java.miniproject.DTO.HabitLogDTO;
import com.team3.sr.java.miniproject.DTO.HabitLogRequestDTO;
import com.team3.sr.java.miniproject.model.entity.HabitLog;

import java.util.List;
import java.util.UUID;

public interface HabitLogService {

    List<HabitLog> getHabitLogsByHabitId(UUID habitId, Integer offset, Integer limit);
    HabitLogDTO createHabitLog(HabitLogRequestDTO habitLogRequestDTO);
}
