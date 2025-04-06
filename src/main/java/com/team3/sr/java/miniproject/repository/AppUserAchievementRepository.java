package com.team3.sr.java.miniproject.repository;

import org.apache.ibatis.annotations.Mapper;
import com.team3.sr.java.miniproject.config.UuidTypeHandler;
import com.team3.sr.java.miniproject.model.entity.AppUserAchievement;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AppUserAchievementRepository {
    @Results(id = "appUserAchievementMapper", value = {
            @Result(property = "appUserAchievementId", column = "app_user_achievement_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR, typeHandler = UuidTypeHandler.class),
            @Result(property = "appUserId", column = "app_user_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR, typeHandler = UuidTypeHandler.class),
            @Result(property = "achievementId", column = "achievement_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR, typeHandler = UuidTypeHandler.class)
    })
    @Select("""
            SELECT * FROM app_user_achievements WHERE app_user_id = #{appUserId}
            """)
    List<AppUserAchievement> findByAppUserId(@Param("appUserId") UUID appUserId);

    @ResultMap("appUserAchievementMapper")
    @Select("""
            SELECT * FROM app_user_achievements WHERE app_user_id = #{appUserId} AND achievement_id = #{achievementId}
            """)
    AppUserAchievement findByAppUserIdAndAchievementId(@Param("appUserId") UUID appUserId, @Param("achievementId") UUID achievementId);

    @Insert("""
            INSERT INTO app_user_achievements (app_user_achievement_id, app_user_id, achievement_id)
            VALUES (#{appUserAchievementId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler},
            #{appUserId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler},
            #{achievementId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler})
            """)
    void insert(AppUserAchievement appUserAchievement);
}
