package com.keanghor.java.miniproject.service.UserService;

import com.keanghor.java.miniproject.model.RequestModel.mail.UserRequest;
import com.keanghor.java.miniproject.model.ResponseModel.UserInfo;
import com.keanghor.java.miniproject.model.dto.UserDto;


public interface UserService {
    Integer register(UserRequest userRequest);

    UserDto getUser(Integer user_id);

    boolean findExistUser(String email);

    UserInfo getUserByEmail(String email);

    void resetPassword(int user_id, String password);
}
