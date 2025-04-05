package com.keanghor.java.miniproject.services.serviceImp;
import com.keanghor.java.miniproject.model.entity.HabitLog;
import com.keanghor.java.miniproject.services.HabitLogService;
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
