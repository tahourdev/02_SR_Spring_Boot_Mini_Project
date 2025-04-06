package com.team3.sr.java.miniproject.repository;

import com.team3.sr.java.miniproject.config.UuidTypeHandler;
import com.team3.sr.java.miniproject.model.entity.Habit;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitRepository {
    @Results(id = "habitMapper", value = {
            @Result(property = "habitId", column = "habit_id"),
            @Result(property = "title", column = "habit_title"),
            @Result(property = "description", column = "description"),
            @Result(property = "frequency", column = "habit_frequency"),
            @Result(property = "isActive", column = "is_active"),
//            @Result(property = "appUserId", column = "app_user_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR, typeHandler = UuidTypeHandler.class),
            @Result(property = "createdAt", column = "created_at")
    })
    @Select("""
            SELECT * FROM habits WHERE habit_id = #{habitId}
            """)
    Habit getHabitById(@Param("habitId") UUID habitId);

    @ResultMap("habitMapper")
    @Select("""
            SELECT * FROM habits OFFSET #{offset} LIMIT #{limit}
            """)
    List<Habit> getHabits(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Insert("""
            INSERT INTO habits (habit_id, habit_title, description, habit_frequency, is_active, app_user_id, created_at)
            VALUES (#{habitId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler}, #{title}, #{description}, #{frequency},
            #{isActive}, #{appUserId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler}, #{createdAt})
            """)
    void insert(Habit habit);
}

