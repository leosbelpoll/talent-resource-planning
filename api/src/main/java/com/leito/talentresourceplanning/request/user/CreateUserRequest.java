package com.leito.talentresourceplanning.request.user;

import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.request.util.BaseCreateRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
public class CreateUserRequest extends BaseCreateRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    private LocalDate birthDate;

    private LifeState lifeState;

    private String lifeStateDescription;
}
