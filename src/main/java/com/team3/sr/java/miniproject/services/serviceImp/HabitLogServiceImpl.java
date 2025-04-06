package com.team3.sr.java.miniproject.services.serviceImp;

import com.team3.sr.java.miniproject.DTO.HabitLogDTO;
import com.team3.sr.java.miniproject.exception.NotFoundException;
import com.team3.sr.java.miniproject.mapper.HabitLogMapperDTO;
import com.team3.sr.java.miniproject.model.entity.AppUser;
import com.team3.sr.java.miniproject.model.entity.Habit;
import com.team3.sr.java.miniproject.model.entity.HabitLog;
import com.team3.sr.java.miniproject.model.enumeration.HabitFrequency;
import com.team3.sr.java.miniproject.model.enumeration.HabitStatus;
import com.team3.sr.java.miniproject.repository.AppUserRepository;
import com.team3.sr.java.miniproject.repository.HabitLogRepository;
import com.team3.sr.java.miniproject.repository.HabitRepository;
import com.team3.sr.java.miniproject.services.HabitLogService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitLogServiceImpl implements HabitLogService {
    private static final Logger logger = LoggerFactory.getLogger(HabitLogService.class);
    private static final long XP_PER_LOG = 10L;
    private static final long XP_PER_LEVEL = 100L;

    private final HabitLogRepository habitLogRepository;
    private final HabitRepository habitRepository;
    private final AppUserRepository appUserRepository;
    private final HabitLogMapperDTO habitLogMapperDTO;

    @Override
    public List<HabitLogDTO> getHabitLogsById(Integer offset, Integer limit, UUID habitId) {
        // Adjust offset for pagination (offset starts at 1, so subtract 1 and multiply by limit)
        offset = (offset - 1) * limit;
        List<HabitLog> habitLogs = habitLogRepository.getHabitLogByHabitId(offset, limit, habitId);
        if (habitLogs.isEmpty()) {
            throw new NotFoundException("No habit logs found for habit with ID: " + habitId);
        }

        for (HabitLog habitLog : habitLogs) {
            if (habitLog.getStatus() != null) {
                try {
                    HabitStatus.valueOf(habitLog.getStatus());
                } catch (IllegalArgumentException e) {
                    logger.error("Invalid status value in database: '{}'. Expected one of: {}", habitLog.getStatus(), Arrays.toString(HabitStatus.values()));
                    throw new IllegalArgumentException("Invalid status value in database: " + habitLog.getStatus(), e);
                }
            }

            Habit habit = habitRepository.getHabitById(habitLog.getHabitId());
            if (habit != null) {
                if (habit.getFrequency() != null) {
                    try {
                        HabitFrequency.valueOf(habit.getFrequency());
                    } catch (IllegalArgumentException e) {
                        logger.error("Invalid frequency value in database: '{}'. Expected one of: {}", habit.getFrequency(), Arrays.toString(HabitFrequency.values()));
                        throw new IllegalArgumentException("Invalid frequency value in database: " + habit.getFrequency(), e);
                    }
                }

                AppUser appUser = appUserRepository.findById(habit.getAppUserId());
                habit.setAppUser(appUser);
                habitLog.setHabit(habit);
            }
        }
        return habitLogs.stream()
                .map(habitLogMapperDTO::toDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public HabitLogDTO createHabitLog(HabitLogDTO habitLogDTO) {
//        if (habitLogDTO.getStatus() != null && !isValidStatus(habitLogDTO.getStatus())) {
//            throw new IllegalArgumentException("Invalid status value. Must be one of: " + Arrays.toString(HabitStatus.values()));
//        }
//
//        if (habitLogDTO.getHabit() != null && habitLogDTO.getHabit().getFrequency() != null) {
//            if (!isValidFrequency(habitLogDTO.getHabit().getFrequency())) {
//                throw new IllegalArgumentException("Invalid frequency value. Must be one of: " + Arrays.toString(HabitFrequency.values()));
//            }
//        }
//
//        AppUser appUser = appUserRepository.findById(habitLogDTO.getHabit().getAppUserResponse().getAppUserId());
//        if (appUser == null) {
//            appUser = AppUser.builder()
//                    .userId(habitLogDTO.getHabit().getAppUserResponse().getAppUserId())
//                    .username(habitLogDTO.getHabit().getAppUserResponse().getUsername())
//                    .email(habitLogDTO.getHabit().getAppUserResponse().getEmail())
//                    .password("password123") // Consider a better approach for production
//                    .level(habitLogDTO.getHabit().getAppUserResponse().getLevel())
//                    .xp(habitLogDTO.getHabit().getAppUserResponse().getXp())
//                    .profileImage(habitLogDTO.getHabit().getAppUserResponse().getProfileImageUrl())
//                    .isVerified(habitLogDTO.getHabit().getAppUserResponse().getIsVerified())
//                    .createdAt(habitLogDTO.getHabit().getAppUserResponse().getCreatedAt())
//                    .build();
//            appUserRepository.insert(appUser);
//        }
//
//        long currentXp = appUser.getXp() != null ? appUser.getXp() : 0L;
//        long newXp = currentXp + XP_PER_LOG;
//        int newLevel = (int) (newXp / XP_PER_LEVEL);
//        appUser.setXp(newXp);
//        appUser.setLevel(newLevel);
//        appUserRepository.update(appUser);
//
//        Habit habit = Habit.builder()
//                .habitId(habitLogDTO.getHabit().getHabitId() != null ? habitLogDTO.getHabit().getHabitId() : UUID.randomUUID())
//                .title(habitLogDTO.getHabit().getTitle())
//                .description(habitLogDTO.getHabit().getDescription())
//                .frequency(habitLogDTO.getHabit().getFrequency() != null ? habitLogDTO.getHabit().getFrequency().name() : null)
//                .isActive(habitLogDTO.getHabit().getIsActive())
//                .appUserId(appUser.getUserId())
//                .createdAt(habitLogDTO.getHabit().getCreatedAt())
//                .build();
//        habitRepository.insert(habit);
//
//        HabitLog habitLog = HabitLog.builder()
//                .logId(UUID.randomUUID())
//                .logDate(habitLogDTO.getLogDate())
//                .status(habitLogDTO.getStatus() != null ? habitLogDTO.getStatus().name() : null)
//                .xpEarned(XP_PER_LOG)
//                .habitId(habit.getHabitId())
//                .build();
//        habitLogRepository.insert(habitLog);
//
//        habit.setAppUser(appUser);
//        habitLog.setHabit(habit);
//        return habitLogMapperDTO.toDTO(habitLog);
//    }
//
//    private boolean isValidStatus(HabitStatus status) {
//        return Arrays.asList(HabitStatus.values()).contains(status);
//    }
//
//    private boolean isValidFrequency(HabitFrequency frequency) {
//        return Arrays.asList(HabitFrequency.values()).contains(frequency);
//    }
}
