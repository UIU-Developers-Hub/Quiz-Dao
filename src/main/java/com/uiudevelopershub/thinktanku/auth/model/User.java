package com.uiudevelopershub.thinktanku.auth.model;

import com.uiudevelopershub.thinktanku.model.quizresult.QuizResult;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
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
    @NotEmpty
    private String password;

    private String profilpic;

    private String address;

    private String phone;

    private String bio;

    private String profession;

    private String fullname;

    private Status status;

    private String coverPicture;

    @OneToMany(mappedBy = "user")  // 'user' refers to the field in QuizResult class
    private List<QuizResult> quizResults;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//     private Set<Posts>posts;

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

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    public String getProfilpic() {
//        return profilpic;
//    }
//
//    public void setProfilpic(String profilpic) {
//        this.profilpic = profilpic;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getBio() {
//        return bio;
//    }
//
//    public void setBio(String bio) {
//        this.bio = bio;
//    }
//
//    public String getProfession() {
//        return profession;
//    }
//
//    public void setProfession(String profession) {
//        this.profession = profession;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    public String getCoverPicture() {
//        return coverPicture;
//    }
//
//    public void setCoverPicture(String coverPicture) {
//        this.coverPicture = coverPicture;
//    }

//    public Set<Posts> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Set<Posts> posts) {
//        this.posts = posts;
//    }
}
