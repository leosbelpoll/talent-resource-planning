package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.controller.util.Mappings;
import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.request.permission.CreatePermissionRequest;
import com.leito.talentresourceplanning.response.permission.CreatePermissionResponse;
import com.leito.talentresourceplanning.response.permission.DetailPermissionResponse;
import com.leito.talentresourceplanning.service.PermissionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Permission Controller")
@RestController
@RequestMapping(Mappings.PERMISSIONS)
public class PermissionController extends CrudController<Permission, CreatePermissionRequest, CreatePermissionResponse, DetailPermissionResponse> {

    PermissionService service;

    public PermissionController(PermissionService service) {
        super(new Permission(), service, new CreatePermissionResponse(), new DetailPermissionResponse());
        this.service = service;
    }
}