package com.leito.talentresourceplanning.response.permission;

import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.response.util.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePermissionResponse extends BaseResponse {
    private String name;

    private String description;

    public CreatePermissionResponse(Permission permission) {
        super(permission);
        setName(permission.getName());
        setDescription(permission.getDescription());

        setLifeState(permission.getLifeState(), permission.getLifeStateDescription());
        setCreatedAt(permission.getCreatedAt());
    }
}
