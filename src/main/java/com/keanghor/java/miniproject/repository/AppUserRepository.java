package com.keanghor.java.miniproject.repository;



import com.keanghor.java.miniproject.model.entity.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppUserRepository {

    @Results(id = "appUserMapper", value = {
            @Result(property = "appUserId", column = "user_id"),
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
}
