package com.uiudevelopershub.thinktanku.service.impl;

import com.uiudevelopershub.thinktanku.dto.request.RoleRequestDTO;
import com.uiudevelopershub.thinktanku.dto.response.CustomRoleResponseDTO;
import com.uiudevelopershub.thinktanku.model.role.Role;
import com.uiudevelopershub.thinktanku.repository.role.RoleRepo;
import com.uiudevelopershub.thinktanku.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private  final RoleRepo roleRepository;

    public void create( RoleRequestDTO requestDto ) {
       Role role = new Role();
       role.setRoleType(requestDto.roleType());
       roleRepository.save(role);
    }


    public CustomRoleResponseDTO readOne(Long id ) {
        CustomRoleResponseDTO singleRoleById = roleRepository.findRoleById( id );
        if ( Objects.isNull( singleRoleById ) ) {
            throw new RuntimeException( "Role with id " + id + " not found." );
        }
        return singleRoleById;
    }


    public String delete( Long id ) {
        Role foundRole = roleRepository
                .findById( id )
                .orElseThrow( () -> new RuntimeException( "Role with id " + id + " not found." ) );
        deleteValidator( foundRole );
        roleRepository.delete( foundRole );

        return "Role Deleted Successfully.";
    }


    private RoleRequestDTO cleanDTOFields( RoleRequestDTO requestDto ) {
        return new RoleRequestDTO(
                requestDto.roleType()
        );
    }


    private void validate( RoleRequestDTO requestDto, Role role ) {
        if ( Objects.isNull( role ) ) {
            Role foundRole = roleRepository.findByRoleType( requestDto.roleType() );

            if ( Objects.nonNull( foundRole ) ) {
                throw new RuntimeException( "Role type already exists." );
            }
        } else {
            if ( ( !( Objects.equals( requestDto.roleType(), role.getRoleType() ) ) && roleRepository.existsByRoleType( requestDto.roleType() ) ) ) {
                throw new RuntimeException( "Role type already exists." );
            }
        }
    }


    private Role toEntityConverter(RoleRequestDTO requestDto, Role role ) {
        if ( Objects.isNull( role ) ) {
            role = new Role();
        }

        role.setRoleType( requestDto.roleType() );

        return role;
    }


    private void deleteValidator( Role role ) {

    }

}
