package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.model.entity.AppUser;
import com.keanghor.java.miniproject.service.ProfileService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ProfileController {
    ProfileService profileService;
    @GetMapping
    public AppUser g

}
