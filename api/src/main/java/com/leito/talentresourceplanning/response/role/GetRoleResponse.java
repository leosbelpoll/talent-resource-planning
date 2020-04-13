package com.leito.talentresourceplanning.response.role;

import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.response.util.BaseDetailResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class GetRoleResponse extends BaseDetailResponse {

    private String name;

    private String description;

    private Set<User> users;

    private Set<Permission> permissions;

    public GetRoleResponse(Role role) {
        super(role);
        setName(role.getName());
        setDescription(role.getDescription());
        setUsers(role.getUsers());
        setPermissions(role.getPermissions());
    }
}
