package com.keanghor.java.miniproject.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Users {
    private Integer user_id;
    private String email;
    private String password;
    private String profile_image;
}
