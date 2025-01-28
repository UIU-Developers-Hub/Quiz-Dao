package com.uiudevelopershub.thinktanku.auth.service;

import com.uiudevelopershub.thinktanku.auth.dto.request.UserRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.request.UserRoleRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.request.UserUpdateRequestDto;
import com.uiudevelopershub.thinktanku.auth.dto.response.CustomUserResponseDTO;
import com.uiudevelopershub.thinktanku.auth.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    public void create(UserRequestDTO requestDto);
    public CustomUserResponseDTO readOne(Long id );
    public User setUserRoles(UserRoleRequestDTO requestDTO );
    public void updateUser(Long id, UserUpdateRequestDto userRequestDTO, MultipartFile file, MultipartFile coverUrl) throws IOException;
    public List<CustomUserResponseDTO> searchByUsername(String username);
}