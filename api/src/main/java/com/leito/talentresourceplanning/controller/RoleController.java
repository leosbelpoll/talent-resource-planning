package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.request.role.CreateRoleRequest;
import com.leito.talentresourceplanning.response.role.CreateRoleResponse;
import com.leito.talentresourceplanning.response.role.GetRoleResponse;
import com.leito.talentresourceplanning.service.RoleService;
import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(Mappings.ROLES)
public class RoleController extends BaseController<Role> {

    RoleService service;

    public RoleController(RoleService service) {
        super(service);
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateRoleResponse> createRole(@RequestBody @Valid CreateRoleRequest request) {
        try {
            Role newRole = service.create(new Role(request));
            return new ResponseEntity<>(new CreateRoleResponse(newRole), new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Item already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

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
