package com.leito.talentresourceplanning.response.role;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.response.util.BaseCreateResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateRoleResponse extends BaseCreateResponse {
    private String name;

    private String description;

    public CreateRoleResponse() {
    }

    @Override
    public void updateByEntity(BaseEntity item) {
        super.updateByEntity(item);
        setName(((Role) item).getName());
        setDescription(((Role) item).getDescription());
    }
}
