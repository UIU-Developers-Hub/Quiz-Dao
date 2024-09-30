package com.uiudevelopershub.thinktanku.model.user;

import com.uiudevelopershub.thinktanku.model.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "_user" )
//@SuperBuilder
//@SQLRestriction( "is_active = TRUE" )
//@SQLDelete( sql = "UPDATE _user SET is_active = FALSE WHERE id = ?" )
//@NamedEntityGraph(
//        name = "User.roles",
//        attributeNodes = @NamedAttributeNode("roles")
//)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    private String username;

    @Column( nullable = false )
    private String email;

    @Column( nullable = false )
    private String password;

    @ManyToMany(
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH },
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "_user_roles",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "roles_id" )
    )

    private Set<Role> roles = new LinkedHashSet<>();

}
