package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leito.talentresourceplanning.request.user.CreateUserRequest;
import com.leito.talentresourceplanning.request.util.BaseCreateRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity(name = User.COLLECTION)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User extends CrudEntity {
    public static final String COLLECTION = "users";

    @Column(unique = true)
    private String username;

    private String password;

    private String name;

    private String lastName;

    private LocalDate birthDate;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    @Override
    public void updateByCreateRequest(BaseCreateRequest request) {
        setUsername(((CreateUserRequest) request).getUsername());
        setName(((CreateUserRequest) request).getName());
        setLastName(((CreateUserRequest) request).getLastName());
        setBirthDate(((CreateUserRequest) request).getBirthDate());
        if (((CreateUserRequest) request).getLifeState() == null) {
            setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        } else {
            setLifeState(((CreateUserRequest) request).getLifeState(), ((CreateUserRequest) request).getLifeStateDescription());
        }
    }
}
