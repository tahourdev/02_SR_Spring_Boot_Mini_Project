package com.keanghor.java.miniproject.service.Email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp  implements  EmailService{
    private final JavaMailSender emailSender;

    public EmailServiceImp(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    @Override
    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cheko.slovaki.yako@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        emailSender.send(message);

        System.out.println("Message sent successfully");
    }
}
