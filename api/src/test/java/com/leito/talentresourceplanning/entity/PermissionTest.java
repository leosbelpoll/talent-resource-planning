package com.leito.talentresourceplanning.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PermissionTest {

    private Permission permission;
    private final String name = "ADMIN";
    private final String description = "App administrator";
    private final Set<Role> roles = new HashSet<>();
    private final Date createdAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20");
    private final Date modifiedAt   = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-23");
    private final Date trashedAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24");
    private final Date removedAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-25");

    PermissionTest() throws Exception {
    }

    @BeforeEach
    void setUp() {
        permission = new Permission();
        permission.setId(1L);
        permission.setName(name);
        permission.setDescription(description);
        permission.setRoles(roles);
        permission.setLifeState(LifeState.CREATED, "CREATED");
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
    void setCreatedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        permission.setCreatedAt(value);

        assertEquals(permission.getCreatedAt(), value);
    }

    @Test
    void setModifiedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        permission.setModifiedAt(value);

        assertEquals(permission.getModifiedAt(), value);
    }

    @Test
    void setTrashedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        permission.setTrashedAt(value);

        assertEquals(permission.getTrashedAt(), value);
    }

    @Test
    void setRemovedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
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
    void getCreatedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        permission.setCreatedAt(value);

        assertEquals(permission.getCreatedAt(), value);
    }

    @Test
    void getModifiedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        permission.setModifiedAt(value);

        assertEquals(permission.getModifiedAt(), value);
    }

    @Test
    void getTrashedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        permission.setTrashedAt(value);

        assertEquals(permission.getTrashedAt(), value);
    }

    @Test
    void getRemovedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        permission.setRemovedAt(value);

        assertEquals(permission.getRemovedAt(), value);
    }
}
