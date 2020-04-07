package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.request.role.CreateRoleRequest;
import com.leito.talentresourceplanning.response.role.CreateRoleResponse;
import com.leito.talentresourceplanning.response.role.GetRoleResponse;
import com.leito.talentresourceplanning.service.RoleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Mappings.ROLES)
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> list = roleService.getAllRoles();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(Mappings.ID_PARAMETER)
    public ResponseEntity<GetRoleResponse> getRoleById(@PathVariable("id") Long id) {
        try {
            Role role = roleService.getRoleById(id);
            return new ResponseEntity<>(new GetRoleResponse(role), new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping
    public ResponseEntity<CreateRoleResponse> createRole(@RequestBody @Valid CreateRoleRequest request) {
        try {
            Role newRole = roleService.create(request.getEntity());
            return new ResponseEntity<>(new CreateRoleResponse(newRole), new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Role already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody @Valid Role role) {
        try {
            Role updatedRole = roleService.update(role);
            return new ResponseEntity<>(updatedRole, new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Role already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
