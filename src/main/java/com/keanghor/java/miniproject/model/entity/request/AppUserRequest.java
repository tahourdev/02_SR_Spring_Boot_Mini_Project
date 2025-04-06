package com.keanghor.java.miniproject.model.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRequest {
    private String appUserName;
    private String email;
    private String password;
    private String profileImage;

}
