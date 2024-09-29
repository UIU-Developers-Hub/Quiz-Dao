package com.uiudevelopershub.thinktanku.dto.response;

import java.util.Set;

/**

 */

public interface CustomUserResponseDTO {
    Long getId();

    String getUsername();

    String getEmail();

    Set< RoleInfo > getRoles();

    interface RoleInfo {
        Long getId();

        String getRoleType();
    }
}