package com.leito.talentresourceplanning.service;

import com.leito.talentresourceplanning.controller.util.StatusCodesMessages;
import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.repository.PermissionRepository;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PermissionServiceTest {

    @Mock
    PermissionRepository permissionRepository;

    @InjectMocks
    PermissionService permissionService;

    @Test
    void getAll() {
        Permission permission1 = new Permission();
        permission1.setId(1L);
        permission1.setName(Constants.permission_name);
        permission1.setDescription(Constants.permission_description);
        permission1.setRoles(Constants.permission_roles);
        permission1.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        permission1.setCreatedAt(Constants.createdAt);

        Permission permission2 = new Permission();
        permission2.setId(2L);
        permission2.setName(Constants.permission_name);
        permission2.setDescription(Constants.permission_description);
        permission2.setRoles(Constants.permission_roles);
        permission2.setLifeState(LifeState.ACTIVATED, LifeState.ACTIVATED.toString());
        permission2.setCreatedAt(Constants.createdAt);
        permission2.setModifiedAt(Constants.modifiedAt);

        when(permissionRepository.findAll()).thenReturn(Arrays.asList(permission1, permission2));

        List<Permission> permissions = permissionService.getAll();

        assertEquals(2, permissions.size());

        assertEquals(1L, permission1.getId());
        assertEquals(Constants.permission_name, permission1.getName());
        assertEquals(Constants.permission_description, permission1.getDescription());
        assertEquals(LifeState.CREATED, permission1.getLifeState());
        assertEquals(LifeState.CREATED.toString(), permission1.getLifeStateDescription());
        assertEquals(Constants.createdAt, permission1.getCreatedAt());

        assertEquals(2L, permission2.getId());
        assertEquals(Constants.permission_name, permission2.getName());
        assertEquals(Constants.permission_description, permission2.getDescription());
        assertEquals(LifeState.ACTIVATED, permission2.getLifeState());
        assertEquals(LifeState.ACTIVATED.toString(), permission2.getLifeStateDescription());
        assertEquals(Constants.createdAt, permission2.getCreatedAt());
        assertEquals(Constants.modifiedAt, permission2.getModifiedAt());
    }

    @Test
    void getById() throws Exception {
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setName(Constants.permission_name);
        permission.setDescription(Constants.permission_description);
        permission.setRoles(Constants.permission_roles);
        permission.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        permission.setCreatedAt(Constants.createdAt);

        when(permissionRepository.findById(any(Long.class))).thenReturn(Optional.of(permission));

        Permission gotPermission = permissionService.getById(1L);

        assertEquals(1L, gotPermission.getId());
        assertEquals(Constants.permission_name, gotPermission.getName());
        assertEquals(Constants.permission_description, gotPermission.getDescription());
        assertEquals(LifeState.CREATED, gotPermission.getLifeState());
        assertEquals(LifeState.CREATED.toString(), gotPermission.getLifeStateDescription());
        assertEquals(Constants.createdAt, gotPermission.getCreatedAt());
    }

    @Test
    void create() {
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setName(Constants.permission_name);
        permission.setDescription(Constants.permission_description);
        permission.setRoles(Constants.permission_roles);

        when(permissionRepository.save(any(Permission.class))).then(AdditionalAnswers.returnsFirstArg());

        Permission newPermission = permissionService.create(permission);

        assertEquals(1L, newPermission.getId());
        assertEquals(Constants.permission_name, newPermission.getName());
        assertEquals(Constants.permission_description, newPermission.getDescription());
        assertEquals(LifeState.CREATED, newPermission.getLifeState());
        assertEquals(LifeState.CREATED.toString(), newPermission.getLifeStateDescription());
        assertNotNull(newPermission.getCreatedAt());
    }

    @Test
    void update() {
        // TODO: Implement this
    }

    @Test
    void trash() throws Exception {
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setName(Constants.permission_name);
        permission.setDescription(Constants.permission_description);
        permission.setRoles(Constants.permission_roles);
        permission.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        permission.setCreatedAt(Constants.createdAt);

        when(permissionRepository.findById(any(Long.class))).thenReturn(Optional.of(permission));
        when(permissionRepository.save(any(Permission.class))).then(AdditionalAnswers.returnsFirstArg());

        Permission trashedPermission = permissionService.trash(1L);

        assertEquals(1L, trashedPermission.getId());
        assertEquals(Constants.permission_name, trashedPermission.getName());
        assertEquals(Constants.permission_description, trashedPermission.getDescription());
        assertEquals(LifeState.TRASHED, trashedPermission.getLifeState());
        assertEquals(LifeState.TRASHED.toString(), trashedPermission.getLifeStateDescription());
        assertEquals(Constants.createdAt, trashedPermission.getCreatedAt());
        assertNotNull(trashedPermission.getTrashedAt());
    }

    @Test
    void trashNotFound() {
        when(permissionRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            permissionService.trash(1L);
        });

        assertEquals(exception.getMessage(), StatusCodesMessages.STATUS_CODE_400);
    }

    @Test
    void remove() throws Exception {
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setName(Constants.permission_name);
        permission.setDescription(Constants.permission_description);
        permission.setRoles(Constants.permission_roles);
        permission.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        permission.setCreatedAt(Constants.createdAt);

        when(permissionRepository.findById(any(Long.class))).thenReturn(Optional.of(permission));
        when(permissionRepository.save(any(Permission.class))).then(AdditionalAnswers.returnsFirstArg());

        Permission trashedPermission = permissionService.remove(1L);

        assertEquals(1L, trashedPermission.getId());
        assertEquals(Constants.permission_name, trashedPermission.getName());
        assertEquals(Constants.permission_description, trashedPermission.getDescription());
        assertEquals(LifeState.REMOVED, trashedPermission.getLifeState());
        assertEquals(LifeState.REMOVED.toString(), trashedPermission.getLifeStateDescription());
        assertEquals(Constants.createdAt, trashedPermission.getCreatedAt());
        assertNotNull(trashedPermission.getRemovedAt());
    }

    @Test
    void removeNotFound() {
        when(permissionRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            permissionService.remove(1L);
        });

        assertEquals(exception.getMessage(), StatusCodesMessages.STATUS_CODE_400);
    }
}