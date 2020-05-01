package com.leito.talentresourceplanning.response.role;

import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.response.util.BaseCreateResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateRoleResponse extends BaseCreateResponse {
    private String name;

    private String description;

    public CreateRoleResponse(Role role) {
        super(role);
        setName(role.getName());
        setDescription(role.getDescription());

        setLifeState(role.getLifeState(), role.getLifeStateDescription());
        setCreatedAt(role.getCreatedAt());
    }
}
