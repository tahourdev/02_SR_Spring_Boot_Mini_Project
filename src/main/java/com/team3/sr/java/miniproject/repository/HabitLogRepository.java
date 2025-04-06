package com.team3.sr.java.miniproject.repository;

import com.team3.sr.java.miniproject.config.UuidTypeHandler;
import com.team3.sr.java.miniproject.model.entity.HabitLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitLogRepository {
    @Results(id = "habitLogMapper", value = {
            @Result(property = "logId", column = "log_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR, typeHandler = UuidTypeHandler.class),
            @Result(property = "logDate", column = "log_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "xpEarned", column = "xp_earned"),
            @Result(property = "habitId", column = "habit_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR, typeHandler = UuidTypeHandler.class)})
    @Select("""
            SELECT * FROM habit_logs WHERE habit_id = #{habitId} OFFSET #{offset} LIMIT #{limit}
            """)
    List<HabitLog> getHabitLogByHabitId(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("habitId") UUID habitId);

    @ResultMap("habitLogMapper")
    @Insert("""
            INSERT INTO habit_logs (log_id, log_date, status, xp_earned, habit_id)
                        VALUES (#{logId}, #{logDate}, #{status},
                        #{xpEarned}, #{habitId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler})
            """)
    void insert(HabitLog habitLog);
}

