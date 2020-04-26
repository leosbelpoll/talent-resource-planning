package com.leito.talentresourceplanning.entity;

import com.leito.talentresourceplanning.request.role.CreateRoleRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RoleTest {

    private Role role;
    private final String name = "ADMIN";
    private final String description = "App administrator";
    private final Set<User> users = new HashSet<>();
    private final Set<Permission> permissions = new HashSet<>();
    private final Date createdAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20");
    private final Date modifiedAt   = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-23");
    private final Date trashedAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24");
    private final Date removedAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-25");

    RoleTest() throws Exception {
    }

    @BeforeEach
    void setUp() {
        role = new Role();
        role.setId(1L);
        role.setName(name);
        role.setDescription(description);
        role.setUsers(users);
        role.setPermissions(permissions);
        role.setLifeState(LifeState.CREATED, "CREATED");
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

        Role role = new Role(request);

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
    void setCreatedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        role.setCreatedAt(value);

        assertEquals(role.getCreatedAt(), value);
    }

    @Test
    void setModifiedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        role.setModifiedAt(value);

        assertEquals(role.getModifiedAt(), value);
    }

    @Test
    void setTrashedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        role.setTrashedAt(value);

        assertEquals(role.getTrashedAt(), value);
    }

    @Test
    void setRemovedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
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
    void getLifeState() {
        LifeState value = LifeState.ACTIVATED;
        String valueDescription = "ACTIVATED";
        role.setLifeState(value, valueDescription);

        assertEquals(role.getLifeState(), value);
        assertEquals(role.getLifeStateDescription(), valueDescription);
    }

    @Test
    void getCreatedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        role.setCreatedAt(value);

        assertEquals(role.getCreatedAt(), value);
    }

    @Test
    void getModifiedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        role.setModifiedAt(value);

        assertEquals(role.getModifiedAt(), value);
    }

    @Test
    void getTrashedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        role.setTrashedAt(value);

        assertEquals(role.getTrashedAt(), value);
    }

    @Test
    void getRemovedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        role.setRemovedAt(value);

        assertEquals(role.getRemovedAt(), value);
    }
}
