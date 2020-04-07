package com.leito.talentresourceplanning.request.user;

import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.request.util.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
public class CreateUserRequest extends BaseRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    private Date birthDate;

    private LifeState lifeState;

    private String lifeStateDescription;

    public User getEntity() {
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);
        if (lifeState == null) {
            user.setLifeState(LifeState.CREATED, "Created");
        } else {
            user.setLifeState(lifeState, lifeStateDescription);
        }

        user.setCreatedAt(new Date());

        return user;
    }
}
