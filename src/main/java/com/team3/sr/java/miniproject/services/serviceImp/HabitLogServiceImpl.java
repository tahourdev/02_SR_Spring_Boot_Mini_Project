package com.team3.sr.java.miniproject.services.serviceImp;
import com.team3.sr.java.miniproject.model.entity.HabitLog;
import com.team3.sr.java.miniproject.services.HabitLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitLogServiceImpl implements HabitLogService {
    @Override
    public List<HabitLog> getAllHabitLogById() {
        return List.of();
    }
}
