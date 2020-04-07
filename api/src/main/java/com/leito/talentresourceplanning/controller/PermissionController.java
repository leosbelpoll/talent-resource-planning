package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.request.permission.CreatePermissionRequest;
import com.leito.talentresourceplanning.response.permission.CreatePermissionResponse;
import com.leito.talentresourceplanning.response.permission.GetPermissionResponse;
import com.leito.talentresourceplanning.service.PermissionService;
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
@RequestMapping(Mappings.PERMISSIONS)
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        List<Permission> list = permissionService.getAllPermissions();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(Mappings.ID_PARAMETER)
    public ResponseEntity<GetPermissionResponse> getPermissionById(@PathVariable("id") Long id) {
        try {
            Permission permission = permissionService.getPermissionById(id);
            return new ResponseEntity<>(new GetPermissionResponse(permission), new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping
    public ResponseEntity<CreatePermissionResponse> createPermission(@RequestBody @Valid CreatePermissionRequest request) {
        try {
            Permission newPermission = permissionService.create(request.getEntity());
            return new ResponseEntity<>(new CreatePermissionResponse(newPermission), new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Permission already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping
    public ResponseEntity<Permission> updatePermission(@RequestBody @Valid Permission permission) {
        try {
            Permission updatedPermission = permissionService.update(permission);
            return new ResponseEntity<>(updatedPermission, new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Permission already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}