package com.uiudevelopershub.thinktanku.auth.service;

import com.uiudevelopershub.thinktanku.auth.dto.request.LoginRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.response.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}
