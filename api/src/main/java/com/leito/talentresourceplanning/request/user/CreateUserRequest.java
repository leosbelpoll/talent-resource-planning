package com.leito.talentresourceplanning.request.user;

import com.leito.talentresourceplanning.entity.LifeState;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
public class CreateUserRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    private Date birthDate;

    private LifeState lifeState;

    private String lifeStateDescription;
}
