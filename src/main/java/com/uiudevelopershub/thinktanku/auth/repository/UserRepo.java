package com.uiudevelopershub.thinktanku.auth.repository;

import com.uiudevelopershub.thinktanku.auth.dto.response.CustomUserResponseDTO;
import com.uiudevelopershub.thinktanku.auth.model.Status;
import com.uiudevelopershub.thinktanku.auth.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long > {

    List<User> findAllByStatus(Status status);

    User findByUsername(String username);

    @EntityGraph( attributePaths = { "roles" } )
    User findByUsernameOrEmail(String username, String email );

    @Query("""
            SELECT u FROM User u where u.username LIKE %:username%""")
    List<CustomUserResponseDTO> searchByUsername(String username );

    boolean existsByEmail( String email );

    @EntityGraph( attributePaths = { "roles" } )
    @Query( """
                SELECT
                    user
                FROM
                    User user
                WHERE
                    user.id = :id
            """ )
    CustomUserResponseDTO findUserByUserId(@Param( "id" ) Long id );


}
