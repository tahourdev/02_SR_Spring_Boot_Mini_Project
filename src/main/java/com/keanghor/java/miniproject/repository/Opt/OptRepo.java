package com.keanghor.java.miniproject.repository.Opt;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface OptRepo {

    @Select("INSERT INTO otps " +
            "VALUES (Default,#{otpCode}," +
            "#{issue_at},#{expiration}," +
            "Default,#{user_id})")
    void setOtp(Integer user_id, Long otpCode, Date issue_at, Date expiration);

    @Select("SELECT user_id FROM otps WHERE opt_code = #{verifyCode}")
    Integer findOtpCode(Long verifyCode);

    @Select("UPDATE otps SET verify = true WHERE opt_code = #{verifyCode} AND user_id= #{user_id}")
    void updateVerify(Integer user_id,Long verifyCode);

    @Select("SELECT user_id FROM otps WHERE user_id= #{userId} AND verify= false")
    Integer isVerify(Integer userId);


    @Select("UPDATE otps SET opt_code= #{otpCode} WHERE user_id= #{userId}")
    void updateVerifyCode(int userId, long otpCode);
}
