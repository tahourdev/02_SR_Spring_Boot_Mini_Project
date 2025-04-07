package com.keanghor.java.miniproject.service.OptService;

import com.keanghor.java.miniproject.repository.Opt.OptRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class OtpServiceImp implements OtpService{
    private final OptRepo optRepo;

    public OtpServiceImp(OptRepo optRepo) {
        this.optRepo = optRepo;
    }

    @Override
    public void setOtp(Integer user_id, Long otpCode, Date issue_at, Date expiration) {
        optRepo.setOtp(user_id,otpCode,
                Date.from(Instant.now()),
                Date.from(Instant.now().
                        plus(1, ChronoUnit.DAYS)));
    }

    @Override
    public Integer findOtpCode(Long verifyCode) {
        return optRepo.findOtpCode(verifyCode);
    }

    @Override
    public void updateVerify(Integer user_id,Long verifyCode) {
        optRepo.updateVerify(user_id,verifyCode);
    }

    @Override
    public boolean isVerify(Integer userId) {
        Integer storeId = optRepo.isVerify(userId);
        return storeId!=null;
    }

    @Override
    public void updateVerifyCode(int user_id, long otpCode) {
        optRepo.updateVerifyCode(user_id,otpCode);
    }
}

