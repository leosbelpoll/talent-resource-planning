package com.leito.talentresourceplanning.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private final String username   = "fperez";
    private final String password   = "Password1";
    private final String name       = "Federico";
    private final String lastName   = "Pérez";
    private final Date birthDate    = new SimpleDateFormat("yyyy-MM-dd").parse("1988-06-17");
    private final Set<Role> roles   = new HashSet<>();
    private final Date createdAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20");
    private final Date modifiedAt   = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-23");
    private final Date trashedAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24");
    private final Date removedAt    = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-25");

    UserTest() throws Exception {
    }

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);
        user.setRoles(roles);
        user.setLifeState(LifeState.CREATED, "CREATED");
        user.setCreatedAt(createdAt);
        user.setModifiedAt(modifiedAt);
        user.setTrashedAt(trashedAt);
        user.setRemovedAt(removedAt);
    }

    @Test
    void emptyConstructor() {
        User user = new User();

        assertNull(user.getName());
    }

    @Test
    void fullConstructor() {
        User user = new User(username, password, name, lastName, birthDate, roles);

        assertEquals(user.getUsername(), username);
        assertEquals(user.getPassword(), password);
        assertEquals(user.getName(), name);
        assertEquals(user.getLastName(), lastName);
        assertEquals(user.getBirthDate(), birthDate);
        assertEquals(user.getRoles(), roles);
    }

    @Test
    void setId() {
        Long value = 2L;
        user.setId(value);

        assertEquals(user.getId(), value);
    }

    @Test
    void setUsername() {
        String value = "testing";
        user.setUsername(value);

        assertEquals(user.getUsername(), value);
    }

    @Test
    void setPassword() {
        String value = "testing";
        user.setPassword(value);

        assertEquals(user.getPassword(), value);
    }

    @Test
    void setName() {
        String value = "testing";
        user.setName(value);

        assertEquals(user.getName(), value);
    }

    @Test
    void setLastName() {
        String value = "testing";
        user.setLastName(value);

        assertEquals(user.getLastName(), value);
    }

    @Test
    void setBirthDate() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("1972-08-20");
        user.setBirthDate(value);

        assertEquals(user.getBirthDate(), value);
    }

    @Test
    void setRoles() {
        Set<Role> value = new HashSet<>(Arrays.asList(new Role("TEST")));
        user.setRoles(value);

        assertEquals(user.getRoles(), value);
    }

    @Test
    void setLifeState() {
        LifeState value = LifeState.ACTIVATED;
        String valueDescription = "ACTIVATED";
        user.setLifeState(value, valueDescription);

        assertEquals(user.getLifeState(), value);
        assertEquals(user.getLifeStateDescription(), valueDescription);
    }

    @Test
    void setCreatedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        user.setCreatedAt(value);

        assertEquals(user.getCreatedAt(), value);
    }

    @Test
    void setModifiedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        user.setModifiedAt(value);

        assertEquals(user.getModifiedAt(), value);
    }

    @Test
    void setTrashedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        user.setTrashedAt(value);

        assertEquals(user.getTrashedAt(), value);
    }

    @Test
    void setRemovedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        user.setRemovedAt(value);

        assertEquals(user.getRemovedAt(), value);
    }

    @Test
    void getId() {
        Long value = 2L;
        user.setId(value);

        assertEquals(user.getId(), value);
    }

    @Test
    void getUsername() {
        String value = "testing";
        user.setUsername(value);

        assertEquals(user.getUsername(), value);
    }

    @Test
    void getPassword() {
        String value = "testing";
        user.setPassword(value);

        assertEquals(user.getPassword(), value);
    }

    @Test
    void getName() {
        String value = "testing";
        user.setName(value);

        assertEquals(user.getName(), value);
    }

    @Test
    void getLastName() {
        String value = "testing";
        user.setLastName(value);

        assertEquals(user.getLastName(), value);
    }

    @Test
    void getBirthDate() throws Exception{
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("1972-08-20");
        user.setBirthDate(value);

        assertEquals(user.getBirthDate(), value);
    }

    @Test
    void getRoles() {
        Set<Role> value = new HashSet<>(Arrays.asList(new Role("TEST")));
        user.setRoles(value);

        assertEquals(user.getRoles(), value);
    }

    @Test
    void getLifeState() {
        LifeState value = LifeState.ACTIVATED;
        String valueDescription = "ACTIVATED";
        user.setLifeState(value, valueDescription);

        assertEquals(user.getLifeState(), value);
        assertEquals(user.getLifeStateDescription(), valueDescription);
    }

    @Test
    void getCreatedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        user.setCreatedAt(value);

        assertEquals(user.getCreatedAt(), value);
    }

    @Test
    void getModifiedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        user.setModifiedAt(value);

        assertEquals(user.getModifiedAt(), value);
    }

    @Test
    void getTrashedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        user.setTrashedAt(value);

        assertEquals(user.getTrashedAt(), value);
    }

    @Test
    void getRemovedAt() throws Exception {
        Date value = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        user.setRemovedAt(value);

        assertEquals(user.getRemovedAt(), value);
    }
}
