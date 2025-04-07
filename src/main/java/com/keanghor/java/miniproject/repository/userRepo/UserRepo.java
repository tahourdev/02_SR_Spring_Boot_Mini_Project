package com.keanghor.java.miniproject.repository.userRepo;

import com.keanghor.java.miniproject.model.RequestModel.mail.UserRequest;
import com.keanghor.java.miniproject.model.ResponseModel.UserInfo;
import com.keanghor.java.miniproject.model.dto.UserDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserRepo {

    @Select("INSERT INTO app_users VALUES" +
            " (Default,#{req.email}," +
            "#{req.password}," +
            "#{req.profileImage})" +
            " RETURNING app_user_id")
    Integer register(@Param("req") UserRequest userRequest);

    @Select("SELECT * FROM app_users WHERE email= #{email} LIMIT 1")
    @Results(
            id = "userMap",
            value = {
                    @Result(property = "profileImage",column = "profile_image"),
                    @Result(property = "userId",column = "user_id"),

            }
    )
    UserInfo getUserByEmail(String email);

    @Select("SELECT * FROM app_users WHERE app_user_id= #{id}")
    @Result(property = "profileImage",column = "profile_image")
    @Result(property = "userId",column = "user_id")
    UserDto getUser(Integer id);


    @Select("SELECT app_user_id FROM app_users WHERE email = #{email} Limit 1")
    Integer findExistUser(String email);


    @Select("UPDATE app_users SET password= #{password} WHERE app_user_id= #{userId}")
    void resetPassword(int userId, String password);

}
