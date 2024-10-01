package com.uiudevelopershub.thinktanku.controller;

import com.uiudevelopershub.thinktanku.dto.request.UserRequestDTO;
import com.uiudevelopershub.thinktanku.dto.request.UserRolesRequestDTO;
import com.uiudevelopershub.thinktanku.dto.response.CustomUserResponseDTO;
import com.uiudevelopershub.thinktanku.model.user.User;
import com.uiudevelopershub.thinktanku.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/User" )
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping()
    public ResponseEntity< String > create( UserRequestDTO requestDto ) {
        userService.create(requestDto);
       return ResponseEntity.ok("Successfully created user");
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @GetMapping( "{id}" )
    public ResponseEntity<CustomUserResponseDTO> readOne(@PathVariable( "id" ) Long id ) {
        return ResponseEntity
                .ok()
                .body( userService.readOne( id ) );
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping( "change-roles" )
    public ResponseEntity<String> setUserRoles(@RequestBody UserRolesRequestDTO requestDTO ) {
      userService.setUserRoles( requestDTO ) ;
      return ResponseEntity.ok("Successfully set user roles");
    }
}