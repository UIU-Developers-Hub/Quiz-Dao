package com.uiudevelopershub.thinktanku.controller;

import com.uiudevelopershub.thinktanku.dto.request.RoleRequestDTO;
import com.uiudevelopershub.thinktanku.dto.response.CustomRoleResponseDTO;
import com.uiudevelopershub.thinktanku.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Role")
public class RoleController {
    private final RoleServiceImpl roleService;

    @PostMapping()
    public ResponseEntity<String> create(RoleRequestDTO requestDto ) {
        roleService.create( requestDto );
        return  ResponseEntity.ok( "Created" );
    }


    @GetMapping( "{id}" )
    public ResponseEntity<CustomRoleResponseDTO> readOne(@PathVariable( "id" ) Long id ) {
        return ResponseEntity
                .ok()
                .body( roleService.readOne( id ) );
    }


    @DeleteMapping( "{id}" )
    public ResponseEntity<String> delete( @PathVariable( "id" ) Long id ) {
        roleService.delete( id );
        return new ResponseEntity<>( "Successfully deleted", HttpStatus.OK );
    }
}

