package com.keanghor.java.miniproject.repository;

import com.keanghor.java.miniproject.config.UuidTypeHandler;
import com.keanghor.java.miniproject.model.entity.AppUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.UUID;

@Mapper
public interface AppUserRepository {

    @Results(id = "appUserMapper", value = {
            @Result(property = "appUserId", column = "user_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UuidTypeHandler.class),
            @Result(property = "userName", column = "username"),
            @Result(property = "profileImage", column = "profile_image"),
            @Result(property = "isVerified", column = "is_verified"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "xp", column = "ex")
    })
    @Select("""
                SELECT * FROM app_users WHERE email = #{email}
            """)
    AppUser getUserByEmail(String email);

    @Select("""
                SELECT * from app_users where username = #{username}
            """)
    AppUser getUserByUsername(String username);

    @Insert("""
                INSERT INTO app_users (user_id, username, password, email, profile_image, is_verified, created_at)
                VALUES (#{appUserId}, #{userName}, #{password}, #{email}, #{profileImage}, #{isVerified}, #{createdAt})
            """)
//    @Options(useGeneratedKeys = true, keyProperty = "appUserId")
    void save(AppUser user);


    boolean existsByEmail(String email);


}
