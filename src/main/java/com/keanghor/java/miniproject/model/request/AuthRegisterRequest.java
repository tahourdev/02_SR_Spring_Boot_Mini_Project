package com.keanghor.java.miniproject.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegisterRequest {
    private String username;
    private String email;
    private String password;
    private String profileImageUrl;
}
