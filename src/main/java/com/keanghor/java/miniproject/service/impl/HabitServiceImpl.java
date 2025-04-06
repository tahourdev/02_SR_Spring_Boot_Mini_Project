package com.keanghor.java.miniproject.service.impl;

import com.keanghor.java.miniproject.model.Entity.Habit;
import com.keanghor.java.miniproject.model.dto.Request.HabitRequest;
import com.keanghor.java.miniproject.repository.HabitRepository;
import com.keanghor.java.miniproject.service.HabitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;

    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @Override
    public List<Habit> getAllHabits(Integer page, Integer size) {
        int offset = (page - 1) * size;
        return habitRepository.getAllHabits(offset, size);
    }

    @Override
    public Habit createHabit(HabitRequest request) {
        return habitRepository.createHabit(request, UUID.fromString("363aa353-db6a-4ff6-824c-acc883ff39a2"));
    }

    @Override
    public void deleteHabitById(UUID habitId) {
        habitRepository.deleteHabitById(habitId);
    }

    @Override
    public Habit updateHabitById(UUID habitId, HabitRequest request) {
        return habitRepository.updateHabitById(habitId,request);
    }

    @Override
    public Habit getHabitById(UUID habitId) {
        return habitRepository.getHabittById(habitId);
    }


}