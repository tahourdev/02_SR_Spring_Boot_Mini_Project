package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.model.Entity.UserResponseToken;
import com.keanghor.java.miniproject.model.RequestModel.mail.RequestLogin;
import com.keanghor.java.miniproject.model.RequestModel.mail.ResetRequest.ResetRequest;
import com.keanghor.java.miniproject.model.RequestModel.mail.UserRequest;
import com.keanghor.java.miniproject.model.RequestModel.mail.mail.MailRequest;
import com.keanghor.java.miniproject.model.ResponseModel.UserInfo;
import com.keanghor.java.miniproject.model.dto.Response.ApiResponse;
import com.keanghor.java.miniproject.model.dto.UserDto;
import com.keanghor.java.miniproject.service.Email.EmailingService;
import com.keanghor.java.miniproject.service.OptService.OtpService;

import com.keanghor.java.miniproject.service.UserService.UserService;
import com.keanghor.java.miniproject.service.authService.AuthenticationService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
@RequestMapping("api/v1/auths")
@AllArgsConstructor
public class AuthController {

    private final EmailingService emailingService;
    private final UserService userService;
    private final OtpService otpService;
    private final BCryptPasswordEncoder pwEncoder;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRequest userRequest) throws MessagingException, NotFoundException, BadRequestException {
        boolean existUser = userService.findExistUser(userRequest.getEmail());
        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword()))
            throw new NotFoundException(userRequest.getPassword() + " doesn't match");
        if (existUser)
            throw new BadRequestException("Email already registered");

        // Insert User to User Table
        userRequest.setPassword(pwEncoder.encode(userRequest.getPassword()));
        Integer storeId = userService.register(userRequest);
        if (storeId != null) {
            // Random OTP code
            Long otpCode = Math.round(Math.random() * 1000000 + 1);

            // Set data to OTP table
            otpService.setOtp(storeId, otpCode,
                    Date.from(Instant.now()),
                    Date.from(Instant.now().plus(1, ChronoUnit.DAYS)));

            // Send the code to the user to verify
            emailingService.sendMail(new MailRequest(
                    userRequest.getEmail(),
                    "Verify your email with OTP code",
                    String.valueOf(otpCode)
            ));
        }

        // Return response
        ApiResponse<UserDto> responseApi = ApiResponse.<UserDto>builder()
                .message("User registered successfully")
                .status(HttpStatus.valueOf(HttpStatus.CREATED.value()))
                .payload(userService.getUser(storeId))
                .instant(Instant.now())
                .build();
        return ResponseEntity.ok(responseApi);
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resendEmail(String resendEmail) throws MessagingException, BadRequestException, NotFoundException {
        boolean notVerify = false;
        UserInfo userInfo = userService.getUserByEmail(resendEmail);
        if (userInfo != null)
            notVerify = otpService.isVerify(Integer.valueOf(userInfo.getUserId()));
        else
            throw new NotFoundException("This email " + resendEmail + " was not found");

        if (notVerify) {
            long otpCode = Math.round(Math.random() * 1000000 + 1);
            otpService.updateVerifyCode(Integer.parseInt(userInfo.getUserId()), otpCode);
            emailingService.sendMail(new MailRequest(
                    userInfo.getEmail(),
                    "Verify your email with OTP code again",
                    String.valueOf(otpCode)
            ));
            return ResponseEntity.ok("Check code in your inbox email");
        } else {
            throw new BadRequestException("Email already verified");
        }
    }

    @PutMapping("/verify")
    public ResponseEntity<?> verifyAccount(Long verifyCode) throws MessagingException, BadRequestException {
        Integer userId = otpService.findOtpCode(verifyCode);
        if (userId == null)
            throw new BadRequestException("Don't match verify code");

        UserDto userInfo = userService.getUser(userId);
        boolean isVerify = otpService.isVerify(Integer.parseInt(userInfo.getUserId()));
        if (!isVerify)
            throw new BadRequestException("Already verified");

        Integer haveCode = otpService.findOtpCode(verifyCode);
        if (haveCode != null) {
            otpService.updateVerify(haveCode, verifyCode);
            emailingService.sendMail(new MailRequest(
                    userInfo.getEmail(),
                    "Verify your email successfully",
                    "Verified"
            ));
            return ResponseEntity.ok("Your account verified successfully");
        } else {
            throw new BadRequestException("Failed to verify, please enter the correct code");
        }
    }

    @PutMapping("/forget")
    public ResponseEntity<?> forgetPassword(String emailToReset, @RequestBody @Valid ResetRequest request) throws BadRequestException, NotFoundException {
        UserInfo userInfo = userService.getUserByEmail(emailToReset);
        boolean isVerify = false;
        if (userInfo != null) {
            isVerify = otpService.isVerify(Integer.parseInt(userInfo.getUserId()));
            if (isVerify)
                throw new BadRequestException("This account is not verified yet.");
            else {
                userService.resetPassword(Integer.parseInt(userInfo.getUserId()), request.getPassword());
                return ResponseEntity.ok("Password reset successfully");
            }
        } else {
            throw new NotFoundException("Email not found");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid RequestLogin requestLogin) throws BadRequestException {
        UserInfo userInfo = userService.getUserByEmail(requestLogin.getEmail());
        boolean isVerify = otpService.isVerify(Integer.parseInt(userInfo.getUserId()));
        if (isVerify)
            throw new BadRequestException("Cannot login because email is not verified");

        UserResponseToken userResponseToken = authenticationService.authenticate(requestLogin);
        return ResponseEntity.ok(userResponseToken);
    }
}