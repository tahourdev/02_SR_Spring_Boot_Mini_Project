package com.team3.sr.java.miniproject.repository;
import com.team3.sr.java.miniproject.config.UuidTypeHandler;
import com.team3.sr.java.miniproject.model.entity.Achievement;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AchievementRepository {
    @Results(id = "achievementMapper", value = {
            @Result(property = "achievementId", column = "achievement_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR, typeHandler = UuidTypeHandler.class),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "badge", column = "badge"),
            @Result(property = "xpRequired", column = "xp_required")
    })
    @Select("""
            SELECT * FROM achievements WHERE achievement_id = #{achievementId}
            """)
    Achievement findById(@Param("achievementId") UUID achievementId);

    @ResultMap("achievementMapper")
    @Select("""
            SELECT * FROM achievements OFFSET #{offset} LIMIT #{limit}
            """)
    List<Achievement> findAll(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
