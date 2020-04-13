package com.leito.talentresourceplanning.response.user;

import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.response.util.BaseDetailResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
public class GetUserResponse extends BaseDetailResponse {

    private String username;

    private String name;

    private String lastName;

    private Date birthDate;

    private Set<Role> roles;

    public GetUserResponse(User user) {
        super(user);
        setUsername(user.getUsername());
        setName(user.getName());
        setLastName(user.getLastName());
        setBirthDate(user.getBirthDate());
        setRoles(user.getRoles());
    }
}
