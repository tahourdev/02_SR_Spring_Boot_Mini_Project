package com.keanghor.java.miniproject.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponse {
    private UUID appUserId;
    private String appUserName;
    private String email;
    private Integer level;
    private Integer xp;
    private String profileImage;
    private boolean isVerified;
    private Date createdAt;
}
