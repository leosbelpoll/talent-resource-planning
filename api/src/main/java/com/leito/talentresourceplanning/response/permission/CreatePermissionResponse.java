package com.leito.talentresourceplanning.response.permission;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.response.util.BaseCreateResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePermissionResponse extends BaseCreateResponse {
    private String name;

    private String description;

    public CreatePermissionResponse() {
    }

    @Override
    public void updateByEntity(BaseEntity item) {
        super.updateByEntity(item);
        setName(((Permission) item).getName());
        setDescription(((Permission) item).getDescription());
    }
}
