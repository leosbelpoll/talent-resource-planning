package com.leito.talentresourceplanning.request.role;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class CreateRoleRequest {
    @NotBlank
    private String name;

    private String description;
}
