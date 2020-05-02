package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.controller.util.Mappings;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.request.role.CreateRoleRequest;
import com.leito.talentresourceplanning.response.role.CreateRoleResponse;
import com.leito.talentresourceplanning.response.role.DetailRoleResponse;
import com.leito.talentresourceplanning.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Role Controller")
@RestController
@RequestMapping(Mappings.ROLES)
public class RoleController extends CrudController<Role, CreateRoleRequest, CreateRoleResponse, DetailRoleResponse> {

    RoleService service;

    public RoleController(RoleService service) {
        super(new Role(), service, new CreateRoleResponse(), new DetailRoleResponse());
        this.service = service;
    }
}
