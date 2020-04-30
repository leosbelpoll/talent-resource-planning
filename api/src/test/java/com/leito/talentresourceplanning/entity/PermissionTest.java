package com.leito.talentresourceplanning.entity;

import com.leito.talentresourceplanning.request.permission.CreatePermissionRequest;
import com.leito.talentresourceplanning.testutils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PermissionTest {

    private Permission permission;
    private final String name = Constants.permission_name;
    private final String description = Constants.permission_description;
    private final Set<Role> roles = Constants.permission_roles;
    private final LocalDate createdAt = Constants.createdAt;
    private final LocalDate modifiedAt = Constants.modifiedAt;
    private final LocalDate trashedAt = Constants.trashedAt;
    private final LocalDate removedAt = Constants.removedAt;

    @BeforeEach
    void setUp() {
        permission = new Permission();
        permission.setId(1L);
        permission.setName(name);
        permission.setDescription(description);
        permission.setRoles(roles);
        permission.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        permission.setCreatedAt(createdAt);
        permission.setModifiedAt(modifiedAt);
        permission.setTrashedAt(trashedAt);
        permission.setRemovedAt(removedAt);
    }

    @Test
    void emptyConstructor() {
        Permission permission = new Permission();

        assertNull(permission.getName());
    }

    @Test
    void nameConstructor() {
        Permission permission = new Permission(name);

        assertEquals(permission.getName(), name);
    }

    @Test
    void fullConstructor() {
        Permission permission = new Permission(name, description);

        assertEquals(permission.getName(), name);
        assertEquals(permission.getDescription(), description);
    }

    @Test
    void requestLifeStateConstructor() {
        CreatePermissionRequest request = new CreatePermissionRequest();
        request.setName(name);
        request.setDescription(description);

        Permission permission = new Permission(request);

        assertEquals(permission.getName(), name);
        assertEquals(permission.getDescription(), description);
    }

    @Test
    void setId() {
        Long value = 2L;
        permission.setId(value);

        assertEquals(permission.getId(), value);
    }

    @Test
    void setName() {
        String value = "testing";
        permission.setName(value);

        assertEquals(permission.getName(), value);
    }

    @Test
    void setDescription() {
        String value = "testing";
        permission.setDescription(value);

        assertEquals(permission.getDescription(), value);
    }

    @Test
    void setRoles() {
        Set<Role> value = new HashSet<>(Arrays.asList(new Role("ADMIN", "App administrator")));
        permission.setRoles(value);

        assertEquals(permission.getRoles(), value);
    }

    @Test
    void setLifeState() {
        LifeState value = LifeState.ACTIVATED;
        String valueDescription = "ACTIVATED";
        permission.setLifeState(value, valueDescription);

        assertEquals(permission.getLifeState(), value);
        assertEquals(permission.getLifeStateDescription(), valueDescription);
    }

    @Test
    void setCreatedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        permission.setCreatedAt(value);

        assertEquals(permission.getCreatedAt(), value);
    }

    @Test
    void setModifiedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        permission.setModifiedAt(value);

        assertEquals(permission.getModifiedAt(), value);
    }

    @Test
    void setTrashedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        permission.setTrashedAt(value);

        assertEquals(permission.getTrashedAt(), value);
    }

    @Test
    void setRemovedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        permission.setRemovedAt(value);

        assertEquals(permission.getRemovedAt(), value);
    }

    @Test
    void getId() {
        Long value = 2L;
        permission.setId(value);

        assertEquals(permission.getId(), value);
    }

    @Test
    void getName() {
        String value = "testing";
        permission.setName(value);

        assertEquals(permission.getName(), value);
    }

    @Test
    void getDescription() {
        String value = "testing";
        permission.setDescription(value);

        assertEquals(permission.getDescription(), value);
    }

    @Test
    void getRoles() {
        Set<Role> value = new HashSet<>(Arrays.asList(new Role("ADMIN", "App administrator")));
        permission.setRoles(value);

        assertEquals(permission.getRoles(), value);
    }

    @Test
    void getLifeState() {
        LifeState value = LifeState.ACTIVATED;
        String valueDescription = "ACTIVATED";
        permission.setLifeState(value, valueDescription);

        assertEquals(permission.getLifeState(), value);
        assertEquals(permission.getLifeStateDescription(), valueDescription);
    }

    @Test
    void getCreatedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        permission.setCreatedAt(value);

        assertEquals(permission.getCreatedAt(), value);
    }

    @Test
    void getModifiedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        permission.setModifiedAt(value);

        assertEquals(permission.getModifiedAt(), value);
    }

    @Test
    void getTrashedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        permission.setTrashedAt(value);

        assertEquals(permission.getTrashedAt(), value);
    }

    @Test
    void getRemovedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        permission.setRemovedAt(value);

        assertEquals(permission.getRemovedAt(), value);
    }
}
