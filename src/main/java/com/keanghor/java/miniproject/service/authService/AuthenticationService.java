package com.keanghor.java.miniproject.service.authService;

import com.keanghor.java.miniproject.config.Jwt.JwtService;
import com.keanghor.java.miniproject.model.Entity.UserResponseToken;
import com.keanghor.java.miniproject.model.RequestModel.mail.RequestLogin;
import com.keanghor.java.miniproject.model.ResponseModel.UserInfo;
import com.keanghor.java.miniproject.repository.userRepo.UserRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final UserRepo userRepository;
    private final AuthenticationManager authenticationManager;

    public UserResponseToken authenticate(@Valid RequestLogin userRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getEmail(),
                        userRequest.getPassword()
                )
        );
        UserInfo userInfo = userRepository.getUserByEmail(userRequest.getEmail());
        userInfo.setConfirmPassword(userInfo.getPassword());
        System.out.println(userInfo.getConfirmPassword());
        System.out.println("User Information: " + userInfo);
        var jwtToken = jwtService.generateToken(userInfo);
        return UserResponseToken.builder().token(jwtToken).build();
    }
}
