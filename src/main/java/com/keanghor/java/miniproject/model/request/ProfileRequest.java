package com.keanghor.java.miniproject.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {

    @NotBlank(message = "Username is required.")
    @Size(min = 2, max = 30, message = "Username must be between 2 and 30 characters.")
    private String username;
    private String profileImageUrl;
}
