package com.uiudevelopershub.thinktanku.auth.controller;

import com.uiudevelopershub.thinktanku.auth.dto.request.LoginRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {

    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );

}
