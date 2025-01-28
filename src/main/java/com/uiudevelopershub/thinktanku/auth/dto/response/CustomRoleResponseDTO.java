package com.uiudevelopershub.thinktanku.auth.dto.response;

import java.util.Set;

public interface CustomRoleResponseDTO {

    Long getId();

    String getRoleType();

    Set< UserInfo > getUsers();

    interface UserInfo {
        Long getId();

        String getUsername();

        String getEmail();
    }
}
