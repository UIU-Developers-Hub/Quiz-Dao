package com.uiudevelopershub.thinktanku.auth.service;


import com.uiudevelopershub.thinktanku.auth.dtos.requests.LoginRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dtos.responses.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}