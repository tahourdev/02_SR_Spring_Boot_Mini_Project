package com.keanghor.java.miniproject.repository;

import com.keanghor.java.miniproject.model.request.HabitRequest;
import com.keanghor.java.miniproject.model.entity.Habit;
import com.keanghor.java.miniproject.model.response.AppUserResponse;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitRepository {

    // Mapper for Habit with joined user
    @Results(id = "habitMapper", value = {
            @Result(property = "habitId", column = "habit_id"),
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "appUserResponse", column = "user_id",
                    one = @One(select = "getUserByHabitId"))
    })
    @Select("""
            SELECT h.habit_id, h.title, h.description, h.frequency, h.is_active, h.created_at,
                   u.user_id, u.username, u.email, u.level, u.ex, u.profile_image,
                   u.is_verified, u.created_at AS user_created_at
            FROM habits h
                     INNER JOIN app_users u ON h.user_id = u.user_id
            WHERE u.user_id = #{userId}
            ORDER BY h.habit_id
            OFFSET #{offset} LIMIT #{limit}
            """)
    List<Habit> getHabitByUserId(@Param("offset") Integer page, @Param("limit") Integer size, UUID userId);

    // User details mapping
    @Select("SELECT * FROM app_users WHERE user_id = #{appUserId}")
    @Results({
            @Result(property = "appUserId", column = "user_id"),
            @Result(property = "appUserName", column = "username"),
            @Result(property = "xp", column = "ex"),
            @Result(property = "profileImage",column = "profile_image"),
            @Result(property = "createdAt",column = "created_at")
    })
    AppUserResponse getUserByHabitId(@Param("appUserId") UUID appUserId);

    // Insert new habit
//    @ResultMap("habitMapper")
    @Select("""
            INSERT INTO habits (title, description, frequency, user_id)
            VALUES (#{request.title}, #{request.description}, #{request.frequency}, #{currentUser})
            RETURNING *;
            """)
    Habit createHabit(@Param("request") HabitRequest request, UUID currentUser);

    // Delete habit by ID
    @Delete("DELETE FROM habits WHERE habit_id = #{habitId}")
    void deleteHabitById(UUID habitId);

    // Mapper for habit by ID
//    @Results(id = "idMapper", value = {
//            @Result(property = "habitId", column = "habit_id"),
//            @Result(property = "title", column = "title"),
//            @Result(property = "description", column = "description"),
//            @Result(property = "frequency", column = "frequency"),
//            @Result(property = "isActive", column = "is_active"),
//            @Result(property = "createdAt", column = "created_at"),
//            @Result(property = "appUserResponse", column = "app_user_id",
//                    one = @One(select = "getUserByHabitId"))
//    })

    // Get habit by ID
    @ResultMap("habitMapper")
    @Select("SELECT * FROM habits WHERE habit_id = #{habitId}")
    Habit getHabitById(UUID habitId);

    // Update habit
//    @ResultMap("idMapper")
    @Select("""
            UPDATE habits
            SET title = #{request.title}, description = #{request.description}, frequency= #{request.frequency}
            WHERE habit_id = #{habitId}
            RETURNING *;
            """)
    @ResultMap("habitMapper")
    Habit updateHabitById(UUID habitId, @Param("request") HabitRequest request);

}
