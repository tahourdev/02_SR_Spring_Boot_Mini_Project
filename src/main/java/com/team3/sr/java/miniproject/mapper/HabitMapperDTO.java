package com.team3.sr.java.miniproject.mapper;

import com.team3.sr.java.miniproject.DTO.HabitDTO;
import com.team3.sr.java.miniproject.model.entity.Habit;
import com.team3.sr.java.miniproject.model.enumeration.HabitFrequency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapperConfig.class, uses = {AppUserMapperDTO.class})
public interface HabitMapperDTO {

    @Mapping(source = "frequency", target = "frequency", resultType = HabitFrequency.class)
    HabitDTO toDTO(Habit habit);

    default HabitFrequency mapFrequency(String frequency) {
        return frequency != null ? HabitFrequency.valueOf(frequency) : null;
    }

    default String mapFrequency(HabitFrequency frequency) {
        return frequency != null ? frequency.name() : null;
    }
}
