package com.team3.sr.java.miniproject.repository;

import com.team3.sr.java.miniproject.config.UuidTypeHandler;
import com.team3.sr.java.miniproject.model.entity.AppUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.UUID;

@Mapper
public interface AppUserRepository {
    @Results(id = "appUserMapper", value = {
            @Result(property = "userId", column = "user_id", javaType = UUID.class, jdbcType = JdbcType.VARCHAR, typeHandler = UuidTypeHandler.class),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "level", column = "level"),
            @Result(property = "xp", column = "xp"),
            @Result(property = "profileImage", column = "profile_image"),
            @Result(property = "isVerified", column = "is_verified"),
            @Result(property = "createdAt", column = "created_at")
    })
    @Select("""
            SELECT * FROM app_users WHERE user_id = #{userId}
            """)
    AppUser findById(@Param("userId") UUID userId);


    @ResultMap("appUserMapper")
    @Update("""
            UPDATE app_users SET xp = #{xp}, level = #{level} WHERE user_id = #{userId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler}
            """)
    void update(AppUser appUser);

    void insert(AppUser appUser);
}
