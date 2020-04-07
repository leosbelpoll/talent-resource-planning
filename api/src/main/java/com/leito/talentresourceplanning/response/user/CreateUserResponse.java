package com.leito.talentresourceplanning.response.user;

import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.response.util.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CreateUserResponse extends BaseResponse {
    private String username;

    private String name;

    private String lastName;

    private Date birthDate;

    private LifeState lifeState;

    private String lifeStateDescription;

    public CreateUserResponse(User user) {
        setUsername(user.getUsername());
        setName(user.getName());
        setLastName(user.getLastName());
        setBirthDate(user.getBirthDate());
        setLifeState(user.getLifeState());
        setLifeStateDescription(user.getLifeStateDescription());

        setLifeState(user.getLifeState(), user.getLifeStateDescription());
        setCreatedAt(user.getCreatedAt());
    }
}
