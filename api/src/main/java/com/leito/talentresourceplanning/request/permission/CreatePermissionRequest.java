package com.leito.talentresourceplanning.request.permission;

import com.leito.talentresourceplanning.request.util.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class CreatePermissionRequest extends  BaseRequest {
    @NotBlank
    private String name;

    private String description;
}
