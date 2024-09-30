package com.uiudevelopershub.thinktanku.service.impl;

import com.uiudevelopershub.thinktanku.dto.request.UserRequestDTO;
import com.uiudevelopershub.thinktanku.dto.request.UserRolesRequestDTO;
import com.uiudevelopershub.thinktanku.dto.response.CustomUserResponseDTO;
import com.uiudevelopershub.thinktanku.model.role.Role;
import com.uiudevelopershub.thinktanku.model.user.User;
import com.uiudevelopershub.thinktanku.notification.SSEService;
import com.uiudevelopershub.thinktanku.repository.role.RoleRepo;
import com.uiudevelopershub.thinktanku.repository.user.UserRepo;
import com.uiudevelopershub.thinktanku.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepository;
    private final SSEService<User> userSSEService;


    public void create( UserRequestDTO requestDto ) {
        User user = new User();
        user.setUsername( requestDto.username() );
        user.setEmail( requestDto.email() );
        user.setPassword( passwordEncoder.encode(requestDto.password() ));
        userRepository.save( user );
        userSSEService.emit( user );

    }

    public CustomUserResponseDTO readOne(Long id ) {
        CustomUserResponseDTO singleUserById = userRepository.findUserByUserId(id);
        if ( Objects.isNull( singleUserById ) ) {
            throw new RuntimeException( "User with id " + id + " not found." );
        }
        return singleUserById;
    }




    public User setUserRoles( UserRolesRequestDTO requestDTO ) {
        User foundUser = userRepository.findById( requestDTO.userId() ).get();

        if ( Objects.isNull( foundUser ) ) {
            throw new RuntimeException( "User with id " + requestDTO.userId() + " not found." );
        }

        Set<Role> foundRoles = roleRepository.findAllByIdIn( requestDTO.roleIds() );
        foundUser.getRoles().addAll( foundRoles );

      return  userRepository.save( foundUser );

    }


}