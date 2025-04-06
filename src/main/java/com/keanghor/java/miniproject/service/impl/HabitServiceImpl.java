package com.keanghor.java.miniproject.service.impl;

import com.keanghor.java.miniproject.model.request.HabitRequest;
import com.keanghor.java.miniproject.model.entity.Habit;
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
    public List<Habit> getHabitByUserId(Integer page, Integer size, UUID userId) {
        int offset = (page - 1) * size;
        return habitRepository.getHabitByUserId(offset, size, userId);
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
        return habitRepository.updateHabitById(habitId, request);
    }

    @Override
    public Habit getHabitById(UUID habitId) {
        return habitRepository.getHabitById(habitId);
    }

}