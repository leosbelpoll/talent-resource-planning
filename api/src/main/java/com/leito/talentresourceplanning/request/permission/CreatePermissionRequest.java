package com.leito.talentresourceplanning.request.permission;

import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.request.util.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
public class CreatePermissionRequest extends  BaseRequest {
    @NotBlank
    private String name;

    private String description;

    public Permission getEntity() {
        Permission role = new Permission();
        role.setName(name);
        role.setDescription(description);

        role.setLifeState(LifeState.CREATED, "");
        role.setCreatedAt(new Date());

        return role;
    }
}
