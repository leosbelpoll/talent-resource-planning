package com.leito.talentresourceplanning.request.role;

import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.request.util.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
public class CreateRoleRequest extends BaseRequest {
    @NotBlank
    private String name;

    private String description;

    public Role getEntity() {
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);

        role.setLifeState(LifeState.CREATED, "Created");
        role.setCreatedAt(new Date());

        return role;
    }
}
