package com.uiudevelopershub.thinktanku.service;

import com.uiudevelopershub.thinktanku.dto.request.UserRequestDTO;
import com.uiudevelopershub.thinktanku.dto.request.UserRolesRequestDTO;
import com.uiudevelopershub.thinktanku.dto.response.CustomUserResponseDTO;
import com.uiudevelopershub.thinktanku.model.user.User;

public interface UserService {
    public void create( UserRequestDTO requestDto );
    public CustomUserResponseDTO readOne(Long id );
    public User setUserRoles(UserRolesRequestDTO requestDTO );
}
