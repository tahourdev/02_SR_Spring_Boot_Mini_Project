package com.keanghor.java.miniproject.repository;


import com.keanghor.java.miniproject.ApiResponse.ApiResponse;
import com.keanghor.java.miniproject.config.UuidTypeHandler;
import com.keanghor.java.miniproject.model.entity.Profile;
import com.keanghor.java.miniproject.model.entity.request.ProfileRequest;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Mapper
public interface ProfileRepository {
    @Results(
            id = "profileMapper", value = {
            @Result(property = "appUserId", column = "user_id", jdbcType = JdbcType.OTHER, javaType = UUID.class, typeHandler = UuidTypeHandler.class),
            @Result(property = "userName", column = "username"),
            @Result(property = "profileImage", column = "profile_image"),
            @Result(property = "isVerified", column = "is_verified"),
            @Result(property = "createdAt", column = "created_at")
    }
    )
    @Select("""
               SELECT * FROM  app_users;
            """)
    Profile getUserProfile();

    @ResultMap("profileMapper")
    @Select("""
             UPDATE  app_users
             SET username = #{req.name}, profile_image = #{req.profileImage}
             WHERE user_id = #{userId}
             RETURNING *;
            """)
    Profile updateProfile(UUID userId, @Param("req") ProfileRequest request);

    @Delete("""
            DELETE FROM  app_users WHERE user_id = #{userId}
            """)
    void deleteProfile(UUID userId);
}
