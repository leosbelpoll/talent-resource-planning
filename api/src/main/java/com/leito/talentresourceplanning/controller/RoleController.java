package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.request.role.CreateRoleRequest;
import com.leito.talentresourceplanning.response.role.CreateRoleResponse;
import com.leito.talentresourceplanning.response.role.GetRoleResponse;
import com.leito.talentresourceplanning.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Api(value = "Role Controller")
@RestController
@RequestMapping(Mappings.ROLES)
public class RoleController extends BaseController<Role> {

    RoleService service;

    public RoleController(RoleService service) {
        super(service);
        this.service = service;
    }

    @ApiOperation(value = "Create item", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = StatusCodesMessages.STATUS_CODE_200),
            @ApiResponse(code = 409, message = StatusCodesMessages.STATUS_CODE_409)
    })
    @PostMapping
    public ResponseEntity<CreateRoleResponse> createRole(@RequestBody @Valid CreateRoleRequest request) {
        try {
            Role newRole = service.create(new Role(request));
            return new ResponseEntity<>(new CreateRoleResponse(newRole), new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Get item", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = StatusCodesMessages.STATUS_CODE_200),
            @ApiResponse(code = 404, message = StatusCodesMessages.STATUS_CODE_404)
    })
    @GetMapping(Mappings.ID_PARAMETER)
    public ResponseEntity<GetRoleResponse> get(@PathVariable("id") Long id) {
        try {
            Role role = service.getById(id);
            return new ResponseEntity<>(new GetRoleResponse(role), new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
