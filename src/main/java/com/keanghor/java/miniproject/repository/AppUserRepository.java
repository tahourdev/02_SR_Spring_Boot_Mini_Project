package com.keanghor.java.miniproject.repository;



import com.keanghor.java.miniproject.model.entity.AppUser;

import com.keanghor.java.miniproject.model.request.AppUserRequest;
import org.apache.ibatis.annotations.*;

import java.util.UUID;

@Mapper
public interface AppUserRepository {

    @Results(id = "appUserMapper", value = {
            @Result(property = "appUserId", column = "user_id"),
            @Result(property = "appUserName", column = "username"),
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

    @Select("""
                INSERT INTO app_users
                VALUES (default, #{request.appUserName}, #{request.email}, #{request.password}, '1','0', #{request.profileImage},false,default)
                RETURNING *
            """)
    @ResultMap("appUserMapper")
    AppUser register(@Param("request") AppUserRequest request);

    @Select("""
                SELECT * FROM app_users
                WHERE user_id = #{userId}
            """)
    @ResultMap("appUserMapper")
    AppUser getUserById(UUID userId);
}
