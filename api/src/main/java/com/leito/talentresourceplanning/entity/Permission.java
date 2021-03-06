package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leito.talentresourceplanning.request.permission.CreatePermissionRequest;
import com.leito.talentresourceplanning.request.util.BaseCreateRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity(name = Permission.COLLECTION)
@NoArgsConstructor
@Setter
@Getter
public class Permission extends CrudEntity{
    public static final String COLLECTION = "permissions";

    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public Permission(String name) {
        setName(name);
    }

    public Permission(String name, String description) {
        this(name);
        setDescription(description);
    }

    @Override
    public void updateByCreateRequest(BaseCreateRequest request) {
        setName(((CreatePermissionRequest) request).getName());
        setDescription(((CreatePermissionRequest) request).getDescription());
    }
}
