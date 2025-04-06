package com.team3.sr.java.miniproject.services.serviceImp;

import com.team3.sr.java.miniproject.DTO.HabitLogDTO;
import com.team3.sr.java.miniproject.DTO.HabitLogRequestDTO;
import com.team3.sr.java.miniproject.mapper.HabitLogMapperDTO;
import com.team3.sr.java.miniproject.model.entity.HabitLog;
import com.team3.sr.java.miniproject.repository.AppUserRepository;
import com.team3.sr.java.miniproject.repository.HabitLogRepository;
import com.team3.sr.java.miniproject.repository.HabitRepository;
import com.team3.sr.java.miniproject.services.AchievementService;
import com.team3.sr.java.miniproject.services.HabitLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitLogServiceImpl implements HabitLogService {
    private static final long XP_PER_LOG = 10L;
    private static final long XP_PER_LEVEL = 100L;

    private final HabitLogRepository habitLogRepository;
    private final HabitRepository habitRepository;
    private final AppUserRepository appUserRepository;
    private final AchievementService achievementService;
    private final HabitLogMapperDTO habitLogMapperDTO;

    @Override
    public List<HabitLog> getHabitLogsByHabitId(UUID habitId, Integer offset, Integer limit) {
        offset = (offset - 1) * limit;
        List<HabitLog> habitLogs = habitLogRepository.getHabitLogsByHabitId(habitId, offset, limit);
         habitLogs.stream()
                .map(habitLogMapperDTO::toDTO)
                .collect(Collectors.toList());

         return habitLogs;
    }

    @Override
    public HabitLogDTO createHabitLog(HabitLogRequestDTO habitLogRequestDTO) {
        return null;
    }

//    @Override
//    public HabitLogDTO createHabitLog(HabitLogRequestDTO habitLogRequestDTO) {
//        Habit habit = habitRepository.getHabitById(habitLogRequestDTO.getHabitId());
//        AppUser appUser = appUserRepository.findById(habit.getAppUserId()).getAppUser();
//        if (appUser == null) {
//            appUser = new AppUser(
//                    UUID.randomUUID(),
//                    "default_user",
//                    "default@example.com",
//                    "password123",
//                    0,
//                    0L,
//                    "https://example.com/default.jpg",
//                    true,
//                    LocalDateTime.now()
//            );
//            appUserRepository.insert(appUser);
//        }
//
//        if (habit == null) {
//            habit = new Habit(
//                    habitLogRequestDTO.getHabitId(),
//                    "Default Habit",
//                    "Default description",
//                    "DAILY",
//                    true,
//                    appUser.getUserId(),
//                    null,
//                    LocalDateTime.now()
//            );
//            habitRepository.insert(habit);
//        }
//
//        // Update XP and level for the app user
//        long currentXp = appUser.getXp() != null ? appUser.getXp() : 0L;
//        long newXp = currentXp + XP_PER_LOG;
//        int newLevel = (int) (newXp / XP_PER_LEVEL);
//        appUser.setXp(newXp);
//        appUser.setLevel(newLevel);
//        appUserRepository.update(appUser);
//
//        // Check for new achievements
//        achievementService.checkAndAwardAchievements(appUser.getUserId(), newXp);
//
//        HabitLog habitLog = new HabitLog(
//                UUID.randomUUID(),
//                LocalDate.now(),
//                habitLogRequestDTO.getStatus() != null ? habitLogRequestDTO.getStatus().name() : null,
//                XP_PER_LOG,
//                habit.getHabitId(),
//                null
//        );
//        habitLogRepository.insert(habitLog);
//
//        habit.setAppUser(appUser);
//        habitLog.setHabit(habit);
//        return habitLogMapperDTO.toDTO(habitLog);
//    }
}
