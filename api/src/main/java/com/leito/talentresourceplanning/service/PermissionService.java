package com.leito.talentresourceplanning.service;

import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.repository.PermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionService extends BaseService<Permission> {

    PermissionRepository repository;

    public PermissionService(PermissionRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
