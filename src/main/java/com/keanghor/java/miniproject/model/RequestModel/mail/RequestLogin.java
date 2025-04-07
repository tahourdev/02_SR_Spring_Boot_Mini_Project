package com.keanghor.java.miniproject.model.RequestModel.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequestLogin {
    private String email;
    private String password;
}
