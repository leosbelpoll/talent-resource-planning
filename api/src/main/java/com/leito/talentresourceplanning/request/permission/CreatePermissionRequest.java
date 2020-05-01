package com.leito.talentresourceplanning.request.permission;

import com.leito.talentresourceplanning.request.util.BaseCreateRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class CreatePermissionRequest extends BaseCreateRequest {
    @NotBlank
    private String name;

    private String description;
}
