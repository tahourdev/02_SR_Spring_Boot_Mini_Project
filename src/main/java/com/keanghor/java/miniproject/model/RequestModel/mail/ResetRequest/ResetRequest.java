package com.keanghor.java.miniproject.model.RequestModel.mail.ResetRequest;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResetRequest {
    @Size(min = 8,message = "Password at least 8 characters")
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Password must contain number and characters")
    private String password;
    @Size(min = 8,message = "Password at least 8 characters")
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Password must contain number and characters")
    private String confirmPassword;
}
