package com.leito.talentresourceplanning.request.role;

import com.leito.talentresourceplanning.request.util.BaseCreateRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class CreateRoleRequest extends BaseCreateRequest {
    @NotBlank
    private String name;

    private String description;
}
