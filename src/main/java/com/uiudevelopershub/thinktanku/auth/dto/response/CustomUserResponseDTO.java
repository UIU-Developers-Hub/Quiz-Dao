package com.uiudevelopershub.thinktanku.auth.dto.response;


import java.util.Set;

/**

 */

public interface CustomUserResponseDTO {

    Long getId();

    String getUsername();

    String getEmail();

    String getProfilpic();

    String getAddress();

    String getPhone();

    String getBio();

    String getProfession();

    String getFullname();

    String getCoverPicture();

    Set< RoleInfo > getRoles();

    interface RoleInfo {
        Long getId();

        String getRoleType();
    }
}
