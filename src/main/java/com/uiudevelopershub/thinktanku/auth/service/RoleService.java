package com.uiudevelopershub.thinktanku.auth.service;

import com.uiudevelopershub.thinktanku.auth.dto.response.CustomRoleResponseDTO;

public interface RoleService {

    public CustomRoleResponseDTO readOne(Long id );
    public String delete( Long id );

}
