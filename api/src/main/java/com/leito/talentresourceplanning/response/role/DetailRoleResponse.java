package com.leito.talentresourceplanning.response.role;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.response.util.BaseDetailResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class DetailRoleResponse extends BaseDetailResponse {

    private String name;

    private String description;

    private Set<User> users;

    private Set<Permission> permissions;

    public DetailRoleResponse() {
    }

    public void updateByEntity(BaseEntity item) {
        super.updateByEntity(item);
        setName(((Role) item).getName());
        setDescription(((Role) item).getDescription());
        setUsers(((Role) item).getUsers());
        setPermissions(((Role) item).getPermissions());
    }
}
