package com.keanghor.java.miniproject.repository;

import com.keanghor.java.miniproject.model.entity.Achievement;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface AchievementRepository {

    @Results(id = "achievementMapper", value = {
            @Result(property = "achievementId", column = "achievement_id"),
            @Result(property = "xpRequired", column = "xp_required")
    })
    @Select("""
            SELECT * FROM achievements
            ORDER BY xp_required
            OFFSET #{offset} LIMIT #{size}
            """)
    List<Achievement> getAllAchievement(Integer offset, Integer size);

    @ResultMap("achievementMapper")
    @Select("""
            SELECT * FROM app_user_achievements ua
            INNER JOIN achievements a
            ON ua.achievement_id = a.achievement_id
            WHERE app_user_id = #{userId}
            """)
    List<Achievement> getAchievementByUserId(Integer offset, Integer size,Long userId);
}
