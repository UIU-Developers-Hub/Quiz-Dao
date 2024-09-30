package com.uiudevelopershub.thinktanku.model.role;

import com.uiudevelopershub.thinktanku.model.user.User;
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
//@SuperBuilder
//@SQLRestriction( "is_active = TRUE" )
//@SQLDelete( sql = "UPDATE role SET is_active = FALSE WHERE id = ?" )
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    private String roleType = "USER";

    @ManyToMany(
            mappedBy = "roles",
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }
    )
    private Set<User> users = new LinkedHashSet<>();

    public Role(String roleType ) {
        this.roleType = roleType;
    }
}
