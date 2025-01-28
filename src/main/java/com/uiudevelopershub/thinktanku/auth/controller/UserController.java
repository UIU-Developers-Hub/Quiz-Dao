package com.uiudevelopershub.thinktanku.auth.controller;

import com.uiudevelopershub.thinktanku.auth.dto.request.UserRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.request.UserRoleRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.request.UserUpdateRequestDto;
import com.uiudevelopershub.thinktanku.auth.dto.response.CustomUserResponseDTO;
import com.uiudevelopershub.thinktanku.auth.model.User;
import com.uiudevelopershub.thinktanku.auth.repository.UserRepo;
import com.uiudevelopershub.thinktanku.auth.service.UserServiceIMPL;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping( "/User" )
public class UserController {

    private UserServiceIMPL userService;
    UserRepo userRepo;

    public UserController( UserServiceIMPL userService ,UserRepo userRepo ) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity< String > create(@ModelAttribute UserRequestDTO requestDto) {
        userService.create(requestDto);
        return ResponseEntity.ok("Successfully created user");
    }


//    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @GetMapping( "{id}" )
    public ResponseEntity<CustomUserResponseDTO> readOne(@PathVariable( "id" ) Long id ) {
        return ResponseEntity
                .ok()
                .body( userService.readOne( id ) );
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping( "change-roles" )
    public ResponseEntity<String> setUserRoles(@RequestBody UserRoleRequestDTO requestDTO ) {
        userService.setUserRoles( requestDTO ) ;
        return ResponseEntity.ok("Successfully set user roles");
    }
    @DeleteMapping
    public ResponseEntity<String>delete(@RequestParam Long id ) {
        userRepo.deleteById( id );
        return ResponseEntity.ok("Successfully deleted user");
    }

    @PutMapping(value = "/update", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String>Update(@RequestParam Long id, @ModelAttribute UserUpdateRequestDto requestDTO ) throws IOException {
        userService.updateUser(id,requestDTO, requestDTO.profilpic(), requestDTO.coverPic());
        return ResponseEntity.ok("Successfully updated user");
    }

    @GetMapping("search/{username}")
    public ResponseEntity<List<CustomUserResponseDTO>> searchByUserName(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.searchByUsername(username));
    }
    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(
            @Payload User user
    ) {
        userService.saveActiveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public User disconnectUser(
            @Payload User user
    ) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users/connected")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }

}