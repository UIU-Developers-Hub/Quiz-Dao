package com.uiudevelopershub.thinktanku.auth.controller;


import com.uiudevelopershub.thinktanku.auth.dtos.requests.LoginRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dtos.responses.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {
    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );
}