package com.keanghor.java.miniproject.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponse {
    private Integer id;
    private String appUserName;
    private String email;
}
