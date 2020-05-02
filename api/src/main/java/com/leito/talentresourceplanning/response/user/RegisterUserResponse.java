package com.leito.talentresourceplanning.response.user;

import com.leito.talentresourceplanning.entity.BaseEntity;
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

    public void updateByEntity(BaseEntity item) {
        super.updateByEntity(item);
        setUsername(((User) item).getUsername());
        setName(((User) item).getName());
        setLastName(((User) item).getLastName());
        setBirthDate(((User) item).getBirthDate());
    }
}
