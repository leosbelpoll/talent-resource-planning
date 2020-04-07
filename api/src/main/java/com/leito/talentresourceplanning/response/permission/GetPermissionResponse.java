package com.leito.talentresourceplanning.response.permission;

import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.response.util.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class GetPermissionResponse extends BaseResponse {
    private String name;

    private String description;

    private Set<Role> roles;

    public GetPermissionResponse(Permission permission) {
        setName(permission.getName());
        setDescription(permission.getDescription());
        setRoles(permission.getRoles());

        setLifeState(permission.getLifeState(), permission.getLifeStateDescription());
        setAllDatesAt(permission);
    }
}
