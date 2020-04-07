package com.leito.talentresourceplanning.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.repository.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository repository;

    public List<Role> getAllRoles() {
        List<Role> roleList = repository.findAll();

        if (roleList.size() > 0) {
            return roleList;
        } else {
            return new ArrayList<>();
        }
    }

    public Role getRoleById(Long id) throws NotFoundException {
        Optional<Role> role = repository.findById(id);

        if (role.isPresent()) {
            return role.get();
        } else {
            throw new NotFoundException("No role record exist for given id");
        }
    }

    public Role create(Role role) {
        Role newRole = repository.save(role);

        return newRole;
    }

    public Role update(Role role) throws NotFoundException {
        Optional<Role> optionalRole = repository.findById(role.getId());

        if (optionalRole.isPresent()) {
            Role newRole = optionalRole.get();

            newRole.setName(role.getName());
            newRole.setDescription(role.getDescription());
            newRole.setModifiedAt(new Date());

            newRole = repository.save(newRole);

            return newRole;
        } else {
            throw new NotFoundException("No role record exist for given id");
        }
    }
}
