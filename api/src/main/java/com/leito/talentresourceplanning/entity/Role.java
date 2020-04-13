package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leito.talentresourceplanning.request.role.CreateRoleRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity(name = Role.COLLECTION)
@NoArgsConstructor
@Setter
@Getter
public class Role extends BaseEntity {
    public static final String COLLECTION = "roles";

    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    public Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @JsonIgnore
    private Set<Permission> permissions = new HashSet<>();

//    @OneToMany
//    @JoinTable(
//            name = "sub_roles",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "subrole_id"))
//    private Set<Role> subRoles = new HashSet<>();


    public Role(String name) {
        setName(name);
    }

    public Role(String name, String description) {
        this(name);
        setDescription(description);
    }

    public Role(CreateRoleRequest request) {
        setName(request.getName());
        setDescription(request.getDescription());
    }

//    public Role(String name, String description, Set<Permission> permissions) {
//        this(name, description);
////        this.permissions = permissions;
//    }
//
//    public Role(String name, String description, Set<Permission> permissions, Set<Role> subRoles) {
//        this(name, description);
////        this.permissions = permissions;
////        this.subRoles = subRoles;
//    }

    public Set<Permission> getPermissions() {
        Set<Permission> permissionsResult = new HashSet<>();
        Set<Role> visitedRoles = new HashSet<>();

        for (Permission permission: permissions) {
            permissionsResult.add(permission);
        }

//        for (Role subRole: subRoles) {
//            if (!visitedRoles.contains(subRole)){
//                visitedRoles.add(subRole);
//                for (Permission permission: subRole.getPermissions()) {
//                    permissionsResult.add(permission);
//                }
//            }
//        }

        return permissionsResult;
    }

    public boolean hasPermission(Permission permission) {
        return getPermissions().contains(permission);
    }
}
