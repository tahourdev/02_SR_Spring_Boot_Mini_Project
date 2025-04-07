package com.keanghor.java.miniproject.model.ResponseModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfo implements UserDetails {
    private String userId;
    @Email(message = "Invalid email")
    private String email;
    @Size(min = 8,message = "Password at lease 8 characters")
    private String password;
    @Size(min = 8,message = "Password at lease 8 characters")
    private String confirmPassword;
    private String profileImage;

    public String getConfirmPassword(){
        return password;
    }


    //    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    //    @JsonIgnore
    @Override
    public String getUsername() {
        return email;
    }

    //    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}