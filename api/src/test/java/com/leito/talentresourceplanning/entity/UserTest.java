package com.leito.talentresourceplanning.entity;

import com.leito.talentresourceplanning.request.user.CreateUserRequest;
import com.leito.talentresourceplanning.testutils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private final String username = Constants.user_username;
    private final String password = Constants.user_textPlainPassword;
    private final String name = Constants.user_name;
    private final String lastName = Constants.user_lastName;
    private final LocalDate birthDate = Constants.user_birthDate;
    private final Set<Role> roles = Constants.user_roles;
    private final LocalDate createdAt = Constants.createdAt;
    private final LocalDate modifiedAt = Constants.modifiedAt;
    private final LocalDate trashedAt = Constants.trashedAt;
    private final LocalDate removedAt = Constants.removedAt;

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
        user.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
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
    void requestLifeStateConstructor() {
        CreateUserRequest request = new CreateUserRequest();
        request.setName(name);
        request.setLastName(lastName);
        request.setUsername(username);
        request.setBirthDate(birthDate);
        request.setLifeState(LifeState.CREATED);
        request.setLifeStateDescription(LifeState.CREATED.toString());

        User user = new User();
        user.updateByCreateRequest(request);

        assertEquals(user.getUsername(), username);
        assertEquals(user.getName(), name);
        assertEquals(user.getLastName(), lastName);
        assertEquals(user.getBirthDate(), birthDate);
        assertEquals(user.getRoles(), roles);
        assertEquals(user.getLifeState(), LifeState.CREATED);
        assertEquals(user.getLifeStateDescription(), LifeState.CREATED.toString());
    }

    @Test
    void requestNoLifeStateConstructor() {
        CreateUserRequest request = new CreateUserRequest();
        request.setName(name);
        request.setLastName(lastName);
        request.setUsername(username);
        request.setBirthDate(birthDate);

        User user = new User();
        user.updateByCreateRequest(request);

        assertEquals(user.getUsername(), username);
        assertEquals(user.getName(), name);
        assertEquals(user.getLastName(), lastName);
        assertEquals(user.getBirthDate(), birthDate);
        assertEquals(user.getRoles(), roles);
        assertEquals(user.getLifeState(), LifeState.CREATED);
        assertEquals(user.getLifeStateDescription(), LifeState.CREATED.toString());
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
    void setBirthDate() {
        LocalDate value = LocalDate.of(1972, 8, 20);
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
    void setCreatedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        user.setCreatedAt(value);

        assertEquals(user.getCreatedAt(), value);
    }

    @Test
    void setModifiedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        user.setModifiedAt(value);

        assertEquals(user.getModifiedAt(), value);
    }

    @Test
    void setTrashedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        user.setTrashedAt(value);

        assertEquals(user.getTrashedAt(), value);
    }

    @Test
    void setRemovedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
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
    void getBirthDate() {
        LocalDate value = LocalDate.of(1972,8, 20);
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
    void getCreatedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        user.setCreatedAt(value);

        assertEquals(user.getCreatedAt(), value);
    }

    @Test
    void getModifiedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        user.setModifiedAt(value);

        assertEquals(user.getModifiedAt(), value);
    }

    @Test
    void getTrashedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        user.setTrashedAt(value);

        assertEquals(user.getTrashedAt(), value);
    }

    @Test
    void getRemovedAt() {
        LocalDate value = LocalDate.of(2020, 3, 20);
        user.setRemovedAt(value);

        assertEquals(user.getRemovedAt(), value);
    }
}
