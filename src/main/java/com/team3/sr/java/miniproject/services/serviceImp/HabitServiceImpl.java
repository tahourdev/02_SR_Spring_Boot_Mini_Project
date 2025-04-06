package com.team3.sr.java.miniproject.services.serviceImp;

import com.team3.sr.java.miniproject.model.entity.Habit;
import com.team3.sr.java.miniproject.repository.HabitRepository;
import com.team3.sr.java.miniproject.services.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;


    @Override
    public List<Habit> getHabits(Integer offset, Integer limit) {
        offset = (offset - 1) * limit;
        List<Habit> habits = habitRepository.getHabits(offset, limit);
        return habits;
    }

//    @Override
//    public HabitDTO createHabit(HabitRequestDTO habitRequestDTO, UUID appUserId) {
//        AppUser appUser = appUserRepository.findById(appUserId).getAppUser();
//        if (appUser == null) {
//            appUser = AppUser.builder()
//                    .userId(appUserId)
//                    .username("default_user")
//                    .email("default_user@example.com")
//                    .password("password123")
//                    .level(0)
//                    .xp(0L)
//                    .profileImage("https://example.com/default.jpg")
//                    .isVerified(false)
//                    .createdAt(LocalDateTime.now())
//                    .build();
//            appUserRepository.insert(appUser);
//        }
//
//        Habit habit = Habit.builder()
//                .habitId(UUID.randomUUID())
//                .title(habitRequestDTO.getTitle())
//                .description(habitRequestDTO.getDescription())
//                .frequency(habitRequestDTO.getFrequency() != null ? habitRequestDTO.getFrequency().name() : null)
//                .isActive(true)
//                .appUserId(appUser.getUserId())
//                .createdAt(LocalDateTime.now())
//                .build();
//        habitRepository.insert(habit);
//
//        habit.setAppUser(appUser);
//        return habitMapperDTO.toDTO(habit);
//    }
}



//                new Habit(
//                UUID.randomUUID(),
//                habitRequestDTO.getTitle(),
//                habitRequestDTO.getDescription(),
//                habitRequestDTO.getFrequency() != null ? habitRequestDTO.getFrequency().name() : null,
//                true,
//                appUser.getUserId(),
//                null,
//                LocalDateTime.now()
//        );
