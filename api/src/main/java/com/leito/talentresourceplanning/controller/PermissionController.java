package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.request.permission.CreatePermissionRequest;
import com.leito.talentresourceplanning.response.permission.CreatePermissionResponse;
import com.leito.talentresourceplanning.response.permission.GetPermissionResponse;
import com.leito.talentresourceplanning.service.PermissionService;
import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(Mappings.PERMISSIONS)
public class PermissionController extends BaseController<Permission> {

    PermissionService service;

    public PermissionController(PermissionService service) {
        super(service);
        this.service = service;
    }

    @GetMapping(Mappings.ID_PARAMETER)
    public ResponseEntity<GetPermissionResponse> get(@PathVariable("id") Long id) {
        try {
            Permission permission = service.getById(id);
            return new ResponseEntity<>(new GetPermissionResponse(permission), new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping
    public ResponseEntity<CreatePermissionResponse> createPermission(@RequestBody @Valid CreatePermissionRequest request) {
        try {
            Permission newPermission = service.create(new Permission(request));
            return new ResponseEntity<>(new CreatePermissionResponse(newPermission), new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Permission already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}