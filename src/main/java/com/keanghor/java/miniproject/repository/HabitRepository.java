package com.keanghor.java.miniproject.repository;

import com.keanghor.java.miniproject.model.Entity.Habit;
import com.keanghor.java.miniproject.model.dto.Request.HabitRequest;
import com.keanghor.java.miniproject.model.dto.Response.AppUserResponse;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitRepository {

    // Mapper for Habit with joined user
    @Results(id = "habitMapper", value = {
            @Result(property = "habitId", column = "habit_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "frequency", column = "frequency"),
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "appUserResponse", column = "app_user_id",
                    one = @One(select = "getUserByHabitId"))
    })
    @Select("""
            SELECT h.habit_id, h.title, h.description, h.frequency, h.is_active, h.created_at,
                   u.app_user_id, u.username, u.email, u.level, u.xp, u.profile_image, 
                   u.is_verified, u.created_at AS user_created_at
            FROM habits h
            INNER JOIN app_users u ON h.app_user_id = u.app_user_id
            ORDER BY h.habit_id
            OFFSET #{offset} LIMIT #{limit}
            """)
    List<Habit> getAllHabits(@Param("offset") Integer page, @Param("limit") Integer size);

    // User details mapping
    @Select("SELECT * FROM app_users WHERE app_user_id = #{appUserId}")
    @Results({
            @Result(property = "appUserId", column = "app_user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "level", column = "level"),
            @Result(property = "xp", column = "xp"),
            @Result(property = "profileImage", column = "profile_image"),
            @Result(property = "isVerified", column = "is_verified"),
            @Result(property = "createdAt", column = "created_at")
    })
    AppUserResponse getUserByHabitId(@Param("appUserId") UUID appUserId);

    // Insert new habit
    @ResultMap("habitMapper")
    @Select("""
            INSERT INTO habits (title, description, frequency, app_user_id)
            VALUES (#{request.title}, #{request.description}, #{request.frequency}, #{currentUser})
            RETURNING *;
            """)
    Habit createHabit(@Param("request") HabitRequest request, UUID currentUser);

    // Delete habit by ID
    @Delete("DELETE FROM habits WHERE habit_id = #{habitId}")
    void deleteHabitById(UUID habitId);

    // Mapper for habit by ID
    @Results(id = "idMapper", value = {
            @Result(property = "habitId", column = "habit_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "frequency", column = "frequency"),
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "appUserResponse", column = "app_user_id",
                    one = @One(select = "getUserByHabitId"))
    })

    // Get habit by ID
    @Select("SELECT * FROM habits WHERE habit_id = #{habitId}")
    Habit getHabitById(UUID habitId);

    // Update habit
    @ResultMap("idMapper")
    @Select("""
            UPDATE habits
            SET title = #{request.title}, description = #{request.description}
            WHERE habit_id = #{habitId}
            RETURNING *;
            """)
    Habit updateHabitById(UUID habitId, @Param("request") HabitRequest request);
}
