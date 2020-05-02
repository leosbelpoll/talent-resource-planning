package com.leito.talentresourceplanning.response.permission;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.response.util.BaseDetailResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class DetailPermissionResponse extends BaseDetailResponse {

    private String name;

    private String description;

    private Set<Role> roles;

    public DetailPermissionResponse() {
    }

    public void updateByEntity(BaseEntity item) {
        super.updateByEntity(item);
        setName(((Permission) item).getName());
        setDescription(((Permission) item).getDescription());
        setRoles(((Permission) item).getRoles());
    }
}
