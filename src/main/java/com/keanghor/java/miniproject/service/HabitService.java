package com.keanghor.java.miniproject.service;

import com.keanghor.java.miniproject.model.request.HabitRequest;
import com.keanghor.java.miniproject.model.entity.Habit;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<Habit> getHabitByUserId(Integer page, Integer size, UUID userId);

    Habit createHabit(HabitRequest request);


    void deleteHabitById(UUID habitId);

    Habit updateHabitById(UUID habitId, HabitRequest request);

    Habit getHabitById(UUID habitId);

}
