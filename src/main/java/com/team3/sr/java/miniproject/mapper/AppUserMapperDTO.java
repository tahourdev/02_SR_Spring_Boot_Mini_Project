package com.team3.sr.java.miniproject.mapper;

import com.team3.sr.java.miniproject.DTO.AppUserDTO;
import com.team3.sr.java.miniproject.model.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapperConfig.class)
public interface AppUserMapperDTO {

    @Mapping(source = "userId", target = "appUserId")
    @Mapping(source = "profileImage", target = "profileImageUrl")
    AppUserDTO toDTO(AppUser appUser);

    @Mapping(source = "appUserId", target = "userId")
    @Mapping(source = "profileImageUrl", target = "profileImage")
    AppUser toEntity(AppUserDTO appUserDTO);
}
