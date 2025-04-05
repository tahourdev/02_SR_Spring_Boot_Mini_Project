package com.keanghor.java.miniproject.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@SecurityRequirement(name = "bearerAuth")
public class BookController {
    @GetMapping
    public String GetBook(){
        return "get book";
    }
}
