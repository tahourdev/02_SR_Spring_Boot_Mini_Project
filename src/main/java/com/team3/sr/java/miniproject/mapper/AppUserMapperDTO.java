package com.team3.sr.java.miniproject.mapper;

import com.team3.sr.java.miniproject.DTO.response.AppUserResponse;
import com.team3.sr.java.miniproject.model.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapperConfig.class)
public interface AppUserMapperDTO {
    @Mapping(source = "userId", target = "appUserId")
    @Mapping(source = "profileImage", target = "profileImageUrl")
    AppUserResponse toResponse(AppUser appUser);
}
