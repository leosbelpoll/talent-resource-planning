package com.leito.talentresourceplanning.entity;

import com.leito.talentresourceplanning.request.role.CreateRoleRequest;
import com.leito.talentresourceplanning.testutils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    private Role role;
    private final String name = Constants.role_name;
    private final String description = Constants.role_description;
    private final Set<User> users = Constants.role_users;
    private final Set<Permission> permissions = Constants.role_permissions;
    private final LocalDate createdAt = Constants.createdAt;
    private final LocalDate modifiedAt = Constants.modifiedAt;
    private final LocalDate trashedAt = Constants.trashedAt;
    private final LocalDate removedAt = Constants.removedAt;

    @BeforeEach
    void setUp() {
        role = new Role();
        role.setId(1L);
        role.setName(name);
        role.setDescription(description);
        role.setUsers(users);
        role.setPermissions(permissions);
        role.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        role.setCreatedAt(createdAt);
        role.setModifiedAt(modifiedAt);
        role.setTrashedAt(trashedAt);
        role.setRemovedAt(removedAt);
    }

    @Test
    void emptyConstructor() {
        Role role = new Role();

        assertNull(role.getName());
    }

    @Test
    void nameConstructor() {
        Role role = new Role(name);

        assertEquals(role.getName(), name);
    }

    @Test
    void fullConstructor() {
        Role role = new Role(name, description);

        assertEquals(role.getName(), name);
        assertEquals(role.getDescription(), description);
    }

    @Test
    void requestLifeStateConstructor() {
        CreateRoleRequest request = new CreateRoleRequest();
        request.setName(name);
        request.setDescription(description);

        Role role = new Role();
        role.updateByCreateRequest(request);

        assertEquals(role.getName(), name);
        assertEquals(role.getDescription(), description);
    }

    @Test
    void setId() {
        Long value = 2L;
        role.setId(value);

        assertEquals(role.getId(), value);
    }

    @Test
    void setName() {
        String value = "testing";
        role.setName(value);

        assertEquals(role.getName(), value);
    }

    @Test
    void setDescription() {
        String value = "testing";
        role.setDescription(value);

        assertEquals(role.getDescription(), value);
    }

    @Test
    void setUsers() {
        Set<User> value = new HashSet<>(Arrays.asList(new User()));
        role.setUsers(value);

        assertEquals(role.getUsers(), value);
    }

    @Test
    void setPermissions() {
        Set<Permission> value = new HashSet<>(Arrays.asList(new Permission("CREATE")));
        role.setPermissions(value);

        assertEquals(role.getPermissions(), value);
    }

    @Test
    void setLifeState() {
        LifeState value = LifeState.ACTIVATED;
        String valueDescription = "ACTIVATED";
        role.setLifeState(value, valueDescription);

        assertEquals(role.getLifeState(), value);
        assertEquals(role.getLifeStateDescription(), valueDescription);
    }

    @Test
    void setCreatedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        role.setCreatedAt(value);

        assertEquals(role.getCreatedAt(), value);
    }

    @Test
    void setModifiedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        role.setModifiedAt(value);

        assertEquals(role.getModifiedAt(), value);
    }

    @Test
    void setTrashedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        role.setTrashedAt(value);

        assertEquals(role.getTrashedAt(), value);
    }

    @Test
    void setRemovedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        role.setRemovedAt(value);

        assertEquals(role.getRemovedAt(), value);
    }

    @Test
    void getId() {
        Long value = 2L;
        role.setId(value);

        assertEquals(role.getId(), value);
    }

    @Test
    void getName() {
        String value = "testing";
        role.setName(value);

        assertEquals(role.getName(), value);
    }

    @Test
    void getDescription() {
        String value = "testing";
        role.setDescription(value);

        assertEquals(role.getDescription(), value);
    }

    @Test
    void getUsers() {
        Set<User> value = new HashSet<>(Arrays.asList(new User()));
        role.setUsers(value);

        assertEquals(role.getUsers(), value);
    }

    @Test
    void getPermissions() {
        Set<Permission> value = new HashSet<>(Arrays.asList(new Permission("CREATE")));
        role.setPermissions(value);

        assertEquals(role.getPermissions(), value);
    }

    @Test
    void hasPermission() {
        Permission permission = new Permission("CREATE_BRIEFCASE");
        Permission permissionDoestHave = new Permission("REMOVE_BRIEFCASE");
        Set<Permission> permissions = new HashSet<>(Arrays.asList(permission));
        role.setPermissions(permissions);

        assertTrue(role.hasPermission(permission));
        assertFalse(role.hasPermission(permissionDoestHave));
    }

    @Test
    void getLifeState() {
        LifeState value = LifeState.ACTIVATED;
        String valueDescription = "ACTIVATED";
        role.setLifeState(value, valueDescription);

        assertEquals(role.getLifeState(), value);
        assertEquals(role.getLifeStateDescription(), valueDescription);
    }

    @Test
    void getCreatedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        role.setCreatedAt(value);

        assertEquals(role.getCreatedAt(), value);
    }

    @Test
    void getModifiedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        role.setModifiedAt(value);

        assertEquals(role.getModifiedAt(), value);
    }

    @Test
    void getTrashedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        role.setTrashedAt(value);

        assertEquals(role.getTrashedAt(), value);
    }

    @Test
    void getRemovedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        role.setRemovedAt(value);

        assertEquals(role.getRemovedAt(), value);
    }
}
