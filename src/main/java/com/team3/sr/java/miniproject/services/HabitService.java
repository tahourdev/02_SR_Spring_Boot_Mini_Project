package com.team3.sr.java.miniproject.services;


import com.team3.sr.java.miniproject.model.entity.Habit;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<Habit> getHabits(Integer offset, Integer limit);
}
