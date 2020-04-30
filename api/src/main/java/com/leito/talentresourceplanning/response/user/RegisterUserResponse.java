package com.leito.talentresourceplanning.response.user;

import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.response.util.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RegisterUserResponse extends BaseResponse {
    private String username;

    private String name;

    private String lastName;

    private LocalDate birthDate;

    public RegisterUserResponse(User user) {
        super(user);
        setUsername(user.getUsername());
        setName(user.getName());
        setLastName(user.getLastName());
        setBirthDate(user.getBirthDate());

        setLifeState(user.getLifeState(), user.getLifeStateDescription());
        setCreatedAt(user.getCreatedAt());
    }
}
