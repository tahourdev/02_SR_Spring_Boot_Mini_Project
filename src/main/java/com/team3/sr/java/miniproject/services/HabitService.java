package com.team3.sr.java.miniproject.services;


import com.team3.sr.java.miniproject.DTO.HabitDTO;
import com.team3.sr.java.miniproject.DTO.HabitRequestDTO;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<HabitDTO> getHabits(Integer offset, Integer limit);
    HabitDTO createHabit(HabitRequestDTO habitRequestDTO, UUID appUserId);
}
