package com.uiudevelopershub.thinktanku.auth.controller;

import com.uiudevelopershub.thinktanku.auth.dto.request.RoleRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.response.CustomRoleResponseDTO;
import com.uiudevelopershub.thinktanku.auth.service.RoleServiceIMPL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("Role")
public class RoleController {

    private RoleServiceIMPL roleService;
    public RoleController(RoleServiceIMPL roleService) {
        this.roleService = roleService;
    }

//     @PreAuthorize( "hasAnyRole('ADMIN')" )
    @PostMapping()
    public ResponseEntity<String> create(RoleRequestDTO requestDto ) {
        roleService.create( requestDto );
        return  ResponseEntity.ok( "Created" );
    }

//    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @GetMapping( "{id}" )
    public ResponseEntity<CustomRoleResponseDTO> readOne(@PathVariable( "id" ) Long id ) {
        return ResponseEntity
                .ok()
                .body( roleService.readOne( id ) );
    }

//    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @DeleteMapping( "{id}" )
    public ResponseEntity<String> delete( @PathVariable( "id" ) Long id ) {
        roleService.delete( id );
        return new ResponseEntity<>( "Successfully deleted", HttpStatus.OK );
    }
}