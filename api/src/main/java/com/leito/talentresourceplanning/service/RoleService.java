package com.leito.talentresourceplanning.service;

import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role> {

    RoleRepository repository;

    public RoleService(RoleRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
