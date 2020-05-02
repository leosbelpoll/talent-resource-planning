package com.leito.talentresourceplanning.response.user;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.response.util.BaseDetailResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
public class DetailUserResponse extends BaseDetailResponse {

    private String username;

    private String name;

    private String lastName;

    private LocalDate birthDate;

    private Set<Role> roles;

    public DetailUserResponse() {
    }

    public void updateByEntity(BaseEntity item) {
        super.updateByEntity(item);
        setUsername(((User) item).getUsername());
        setName(((User) item).getName());
        setLastName(((User) item).getLastName());
        setBirthDate(((User) item).getBirthDate());
        setRoles(((User) item).getRoles());
    }
}
