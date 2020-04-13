package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leito.talentresourceplanning.request.user.CreateUserRequest;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = User.COLLECTION)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User extends BaseEntity{
    public static final String COLLECTION = "users";

    @Column(unique = true)
    private String username;

    private String password;

    private String name;

    private String lastName;

    private Date birthDate;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public User(CreateUserRequest request) {
        setUsername(request.getUsername());
        setName(request.getName());
        setLastName(request.getLastName());
        setBirthDate(request.getBirthDate());
        if (request.getLifeState() == null) {
            setLifeState(LifeState.CREATED, "CREATED");
        } else {
            setLifeState(request.getLifeState(), request.getLifeStateDescription());
        }
    }
}
