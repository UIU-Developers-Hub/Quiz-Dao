package com.uiudevelopershub.thinktanku.config.security;

import com.uiudevelopershub.thinktanku.auth.CustomUserDetails;
import com.uiudevelopershub.thinktanku.model.role.Role;
import com.uiudevelopershub.thinktanku.model.user.User;
import com.uiudevelopershub.thinktanku.repository.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsernameOrEmail( username.strip(), username.strip() );
        if ( Objects.isNull( foundUser ) ) {
            throw new UsernameNotFoundException( username );
        }

        Set< String > grantedAuthorities = foundUser
                .getRoles()
                .stream()
                .map(Role::getRoleType )
                .collect( Collectors.toSet() );

        return CustomUserDetails
                .builder()
                .id( foundUser.getId() )
                .username( foundUser.getUsername() )
                .password( foundUser.getPassword() )
                .email( foundUser.getEmail() )
                .roles( grantedAuthorities )
                .build();
    }
}