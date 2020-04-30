package com.leito.talentresourceplanning.request.user;

import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.request.util.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
public class RegisterUserRequest extends BaseRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    private LocalDate birthDate;

    public User getEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);

        user.setLifeState(LifeState.REGISTERED, LifeState.REGISTERED.toString());
        user.setCreatedAt(LocalDate.now());

        return user;
    }
}
