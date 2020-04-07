package com.leito.talentresourceplanning.service;

import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.repository.PermissionRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    PermissionRepository repository;

    public List<Permission> getAllPermissions() {
        List<Permission> permissionList = repository.findAll();

        if (permissionList.size() > 0) {
            return permissionList;
        } else {
            return new ArrayList<>();
        }
    }

    public Permission getPermissionById(Long id) throws NotFoundException {
        Optional<Permission> permission = repository.findById(id);

        if (permission.isPresent()) {
            return permission.get();
        } else {
            throw new NotFoundException("No permission record exist for given id");
        }
    }

    public Permission create(Permission permission) {
        Permission newPermission = repository.save(permission);

        return newPermission;
    }

    public Permission update(Permission permission) throws NotFoundException {
        Optional<Permission> optionalPermission = repository.findById(permission.getId());

        if (optionalPermission.isPresent()) {
            Permission newPermission = optionalPermission.get();

            newPermission.setName(permission.getName());
            newPermission.setDescription(permission.getDescription());
            newPermission.setModifiedAt(new Date());

            newPermission = repository.save(newPermission);

            return newPermission;
        } else {
            throw new NotFoundException("No permission record exist for given id");
        }
    }
}
