package com.keanghor.java.miniproject.model.RequestModel.mail.mail;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {
    @JsonAlias(value = "to_email")
    private String toEmail;

    private String subject;

    private String message;

    @JsonAlias(value = "html")
    private boolean isHTML;

    public MailRequest(String toEmail,String title,String message){
        this.isHTML = true;
        this.toEmail = toEmail;
        this.subject = title;
        this.message = message;
    }
}
