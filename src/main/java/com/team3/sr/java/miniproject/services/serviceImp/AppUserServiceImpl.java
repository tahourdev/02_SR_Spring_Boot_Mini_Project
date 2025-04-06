package com.team3.sr.java.miniproject.services.serviceImp;

import com.team3.sr.java.miniproject.DTO.AppUserDTO;
import com.team3.sr.java.miniproject.mapper.AppUserMapperDTO;
import com.team3.sr.java.miniproject.model.entity.AppUser;
import com.team3.sr.java.miniproject.repository.AppUserRepository;
import com.team3.sr.java.miniproject.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserMapperDTO appUserMapperDTO;

    @Override
    public AppUserDTO getAppUser() {
        AppUser appUser = appUserRepository.findUser();
        return appUserMapperDTO.toDTO(appUser);
    }
}
