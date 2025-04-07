package com.keanghor.java.miniproject.model.RequestModel.mail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @Email(message = "Invalid email")
    private String email;
    @Size(min = 8,message = "Password at lease 8 characters")
    private String password;
    @Size(min = 8,message = "Password at lease 8 characters")
    private String confirmPassword;
    @NotNull(message = "please insert an image")
    private String profileImage;
}
