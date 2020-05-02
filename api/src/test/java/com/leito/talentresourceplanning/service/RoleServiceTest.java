package com.leito.talentresourceplanning.service;

import com.leito.talentresourceplanning.controller.util.StatusCodesMessages;
import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.repository.RoleRepository;
import com.leito.talentresourceplanning.testutils.Constants;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleServiceTest {

    @Mock
    RoleRepository roleRepository;

    @InjectMocks
    RoleService roleService;

    @Test
    void getAll() {
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName(Constants.role_name);
        role1.setDescription(Constants.role_description);
        role1.setUsers(Constants.role_users);
        role1.setPermissions(Constants.role_permissions);
        role1.setLifeState(LifeState.CREATED);
        role1.setCreatedAt(Constants.createdAt);

        Role role2 = new Role();
        role2.setId(2L);
        role2.setName(Constants.role_name);
        role2.setDescription(Constants.role_description);
        role2.setUsers(Constants.role_users);
        role2.setPermissions(Constants.role_permissions);
        role2.setLifeState(LifeState.ACTIVATED);
        role2.setCreatedAt(Constants.createdAt);
        role2.setModifiedAt(Constants.modifiedAt);

        when(roleRepository.findAll()).thenReturn(Arrays.asList(role1, role2));

        List<Role> roles = roleService.getAll();

        assertEquals(2, roles.size());

        assertEquals(1L, role1.getId());
        assertEquals(Constants.role_name, role1.getName());
        assertEquals(Constants.role_description, role1.getDescription());
        assertEquals(Constants.role_users, role1.getUsers());
        assertEquals(Constants.role_permissions, role1.getPermissions());
        assertEquals(LifeState.CREATED, role1.getLifeState());
        assertEquals(LifeState.CREATED.toString(), role1.getLifeStateDescription());
        assertEquals(Constants.createdAt, role1.getCreatedAt());

        assertEquals(2L, role2.getId());
        assertEquals(Constants.role_name, role2.getName());
        assertEquals(Constants.role_description, role2.getDescription());
        assertEquals(Constants.role_users, role2.getUsers());
        assertEquals(Constants.role_permissions, role2.getPermissions());
        assertEquals(LifeState.ACTIVATED, role2.getLifeState());
        assertEquals(LifeState.ACTIVATED.toString(), role2.getLifeStateDescription());
        assertEquals(Constants.createdAt, role2.getCreatedAt());
        assertEquals(Constants.modifiedAt, role2.getModifiedAt());
    }

    @Test
    void getById() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName(Constants.role_name);
        role.setDescription(Constants.role_description);
        role.setUsers(Constants.role_users);
        role.setPermissions(Constants.role_permissions);
        role.setLifeState(LifeState.CREATED);
        role.setCreatedAt(Constants.createdAt);

        when(roleRepository.findById(any(Long.class))).thenReturn(Optional.of(role));

        Role gotRole = roleService.getById(1L);

        assertEquals(1L, gotRole.getId());
        assertEquals(Constants.role_name, gotRole.getName());
        assertEquals(Constants.role_description, gotRole.getDescription());
        assertEquals(Constants.role_users, role.getUsers());
        assertEquals(Constants.role_permissions, role.getPermissions());
        assertEquals(LifeState.CREATED, gotRole.getLifeState());
        assertEquals(LifeState.CREATED.toString(), gotRole.getLifeStateDescription());
        assertEquals(Constants.createdAt, gotRole.getCreatedAt());
    }

    @Test
    void create() {
        Role role = new Role();
        role.setId(1L);
        role.setName(Constants.role_name);
        role.setDescription(Constants.role_description);
        role.setUsers(Constants.role_users);
        role.setPermissions(Constants.role_permissions);

        when(roleRepository.save(any(Role.class))).then(AdditionalAnswers.returnsFirstArg());

        Role newRole = roleService.create(role);

        assertEquals(1L, newRole.getId());
        assertEquals(Constants.role_name, newRole.getName());
        assertEquals(Constants.role_description, newRole.getDescription());
        assertEquals(Constants.role_users, role.getUsers());
        assertEquals(Constants.role_permissions, role.getPermissions());
        assertEquals(LifeState.CREATED, newRole.getLifeState());
        assertEquals(LifeState.CREATED.toString(), newRole.getLifeStateDescription());
        assertNotNull(newRole.getCreatedAt());
    }

    @Test
    void update() {
        // TODO: Implement this
    }

    @Test
    void trash() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName(Constants.role_name);
        role.setDescription(Constants.role_description);
        role.setUsers(Constants.role_users);
        role.setPermissions(Constants.role_permissions);
        role.setLifeState(LifeState.CREATED);
        role.setCreatedAt(Constants.createdAt);

        when(roleRepository.findById(any(Long.class))).thenReturn(Optional.of(role));
        when(roleRepository.save(any(Role.class))).then(AdditionalAnswers.returnsFirstArg());

        Role trashedRole = roleService.trash(1L);

        assertEquals(1L, trashedRole.getId());
        assertEquals(Constants.role_name, trashedRole.getName());
        assertEquals(Constants.role_description, trashedRole.getDescription());
        assertEquals(Constants.role_users, role.getUsers());
        assertEquals(Constants.role_permissions, role.getPermissions());
        assertEquals(LifeState.TRASHED, trashedRole.getLifeState());
        assertEquals(LifeState.TRASHED.toString(), trashedRole.getLifeStateDescription());
        assertEquals(Constants.createdAt, trashedRole.getCreatedAt());
        assertNotNull(trashedRole.getTrashedAt());
    }

    @Test
    void trashNotFound() {
        when(roleRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            roleService.trash(1L);
        });

        assertEquals(exception.getMessage(), StatusCodesMessages.STATUS_CODE_400);
    }

    @Test
    void remove() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName(Constants.role_name);
        role.setDescription(Constants.role_description);
        role.setUsers(Constants.role_users);
        role.setPermissions(Constants.role_permissions);
        role.setLifeState(LifeState.CREATED);
        role.setCreatedAt(Constants.createdAt);

        when(roleRepository.findById(any(Long.class))).thenReturn(Optional.of(role));
        when(roleRepository.save(any(Role.class))).then(AdditionalAnswers.returnsFirstArg());

        Role trashedRole = roleService.remove(1L);

        assertEquals(1L, trashedRole.getId());
        assertEquals(Constants.role_name, trashedRole.getName());
        assertEquals(Constants.role_description, trashedRole.getDescription());
        assertEquals(Constants.role_users, role.getUsers());
        assertEquals(Constants.role_permissions, role.getPermissions());
        assertEquals(LifeState.REMOVED, trashedRole.getLifeState());
        assertEquals(LifeState.REMOVED.toString(), trashedRole.getLifeStateDescription());
        assertEquals(Constants.createdAt, trashedRole.getCreatedAt());
        assertNotNull(trashedRole.getRemovedAt());
    }

    @Test
    void removeNotFound() {
        when(roleRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            roleService.remove(1L);
        });

        assertEquals(exception.getMessage(), StatusCodesMessages.STATUS_CODE_400);
    }
}