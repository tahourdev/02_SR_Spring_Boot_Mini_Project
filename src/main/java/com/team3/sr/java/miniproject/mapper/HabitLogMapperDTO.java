package com.team3.sr.java.miniproject.mapper;

import com.team3.sr.java.miniproject.DTO.HabitLogDTO;
import com.team3.sr.java.miniproject.model.entity.HabitLog;
import com.team3.sr.java.miniproject.model.enumeration.HabitStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapperConfig.class, uses = {HabitMapperDTO.class})
public interface HabitLogMapperDTO {

    @Mapping(source = "logId", target = "habitLogId")
    @Mapping(source = "status", target = "status", resultType = HabitStatus.class)
    HabitLogDTO toDTO(HabitLog habitLog);

    @Mapping(source = "habitLogId", target = "logId")
    @Mapping(source = "status", target = "status", resultType = String.class)
    HabitLog toEntity(HabitLogDTO habitLogDTO);

    default HabitStatus mapStatus(String status) {
        return status != null ? HabitStatus.valueOf(status) : null;
    }

    default String mapStatus(HabitStatus status) {
        return status != null ? status.name() : null;
    }
}
