package com.uiudevelopershub.thinktanku.service;

import com.uiudevelopershub.thinktanku.dto.request.RoleRequestDTO;
import com.uiudevelopershub.thinktanku.dto.response.CustomRoleResponseDTO;

public interface RoleService {
    public CustomRoleResponseDTO readOne(Long id );
    public String delete( Long id );
}
