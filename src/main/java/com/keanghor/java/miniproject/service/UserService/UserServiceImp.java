package com.keanghor.java.miniproject.service.UserService;

import com.keanghor.java.miniproject.model.RequestModel.mail.UserRequest;
import com.keanghor.java.miniproject.model.ResponseModel.UserInfo;
import com.keanghor.java.miniproject.model.dto.UserDto;
import com.keanghor.java.miniproject.repository.userRepo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService, UserDetailsService {
    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    public UserServiceImp(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    @Override
    public Integer register(UserRequest userRequest) {
        return userRepo.register(userRequest);
    }

    @Override
    public UserDto getUser(Integer user_id) {
        return userRepo.getUser(user_id);
    }

    @Override
    public boolean findExistUser(String email) {
        Integer existUser = userRepo.findExistUser(email);
        return existUser!=null;
    }

    @Override
    public UserInfo getUserByEmail(String email) {
        return userRepo.getUserByEmail(email);
    }

    @Override
    public void resetPassword(int user_id, String password) {
        userRepo.resetPassword(user_id,password);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo userInfo = userRepo.getUserByEmail(email);
        System.out.println("User found : "+userInfo);
        if (userInfo == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return null;
    }
}
