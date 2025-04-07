package com.keanghor.java.miniproject.controller;

import com.keanghor.java.miniproject.service.Email.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping("/send-email")
    public ResponseEntity<?> sendMessage(@RequestBody String msg){

        this.emailService.sendEmail("ounmarkara71@gmail.com","hello there", String.valueOf(Math.round(Math.random()*1000000+1)));

        return null;
    }
}
