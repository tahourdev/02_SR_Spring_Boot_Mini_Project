package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.jwt.JwtService;

import com.keanghor.java.miniproject.model.request.AppUserRequest;
import com.keanghor.java.miniproject.model.request.AuthRequest;
import com.keanghor.java.miniproject.model.response.APIResponse;
import com.keanghor.java.miniproject.model.response.AppUserResponse;
import com.keanghor.java.miniproject.model.response.AuthResponse;
import com.keanghor.java.miniproject.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@Slf4j
@RestController
@RequestMapping("/api/v1/auths")
@RequiredArgsConstructor
public class AuthController {
    private final AppUserService appUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private void authenticate(String email, String password) throws Exception {
        try {
            log.info(email,password+"sdsdsdsd");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<?>> authenticate(@RequestBody AuthRequest request) throws Exception {
        authenticate(request.getEmail(), request.getPassword());
        final UserDetails userDetails = appUserService.loadUserByUsername(request.getEmail());
        final String token = jwtService.generateToken(userDetails);
        AuthResponse authResponse = new AuthResponse(token);
        APIResponse<AuthResponse> response = APIResponse.<AuthResponse>builder()
            .success(true)
            .message("Login successfully! Authentication token generated.")
            .status(HttpStatus.OK)
            .payload(authResponse)
            .instant(Instant.now())
            .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/register")
    public ResponseEntity<APIResponse<?>> register(@RequestBody AppUserRequest request){
        AppUserResponse appUserResponse = appUserService.register(request);
        APIResponse<AppUserResponse> response = APIResponse.<AppUserResponse>builder()
                .success(true)
                .message("User registered successfully! Please verify your email to complete the registration.")
                .status(HttpStatus.CREATED)
                .payload(appUserResponse)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
