package com.keanghor.java.miniproject.service.OptService;

import java.util.Date;

public interface OtpService {
    void setOtp(Integer user_id, Long otpCode, Date issue_at, Date expiration);
    Integer findOtpCode(Long verifyCode);

    void updateVerify(Integer user_id,Long verifyCode);

    boolean isVerify(Integer userId);

    void updateVerifyCode(int i, long otpCode);
}