package com.keanghor.java.miniproject.service;

import com.keanghor.java.miniproject.model.Entity.Habit;
import com.keanghor.java.miniproject.model.dto.Request.HabitRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<Habit> getAllHabits(Integer page, Integer size);

    Habit createHabit(HabitRequest request);


    void deleteHabitById(UUID habitId);

    Habit updateHabitById(UUID habitId, HabitRequest request);

    Habit getHabitById(UUID habitId);
}
