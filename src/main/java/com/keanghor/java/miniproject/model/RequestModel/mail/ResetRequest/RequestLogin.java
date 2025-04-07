package com.keanghor.java.miniproject.model.RequestModel.mail.ResetRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestLogin {
    @Email(message = "invalid email")
    private String email;
    @Size(min = 8)
    private String password;
}
