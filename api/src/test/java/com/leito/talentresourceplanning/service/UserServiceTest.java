package com.leito.talentresourceplanning.service;

import com.leito.talentresourceplanning.controller.util.StatusCodesMessages;
import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.repository.UserRepository;
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
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void getAll() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName(Constants.user_name);
        user1.setUsername(Constants.user_username);
        user1.setLastName(Constants.user_lastName);
        user1.setBirthDate(Constants.user_birthDate);
        user1.setRoles(Constants.user_roles);
        user1.setLifeState(LifeState.CREATED);
        user1.setCreatedAt(Constants.createdAt);

        User user2 = new User();
        user2.setId(2L);
        user2.setName(Constants.user_name);
        user2.setUsername(Constants.user_username);
        user2.setLastName(Constants.user_lastName);
        user2.setBirthDate(Constants.user_birthDate);
        user2.setRoles(Constants.user_roles);
        user2.setLifeState(LifeState.ACTIVATED);
        user2.setCreatedAt(Constants.createdAt);
        user2.setModifiedAt(Constants.modifiedAt);

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAll();

        assertEquals(2, users.size());

        assertEquals(1L, user1.getId());
        assertEquals(Constants.user_name, user1.getName());
        assertEquals(Constants.user_username, user1.getUsername());
        assertEquals(Constants.user_lastName, user1.getLastName());
        assertEquals(Constants.user_birthDate, user1.getBirthDate());
        assertEquals(Constants.user_roles, user1.getRoles());
        assertEquals(LifeState.CREATED, user1.getLifeState());
        assertEquals(LifeState.CREATED.toString(), user1.getLifeStateDescription());
        assertEquals(Constants.createdAt, user1.getCreatedAt());

        assertEquals(2L, user2.getId());
        assertEquals(Constants.user_name, user2.getName());
        assertEquals(Constants.user_username, user2.getUsername());
        assertEquals(Constants.user_lastName, user2.getLastName());
        assertEquals(Constants.user_birthDate, user2.getBirthDate());
        assertEquals(Constants.user_roles, user2.getRoles());
        assertEquals(LifeState.ACTIVATED, user2.getLifeState());
        assertEquals(LifeState.ACTIVATED.toString(), user2.getLifeStateDescription());
        assertEquals(Constants.createdAt, user2.getCreatedAt());
        assertEquals(Constants.modifiedAt, user2.getModifiedAt());
    }

    @Test
    void getById() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName(Constants.user_name);
        user.setUsername(Constants.user_username);
        user.setLastName(Constants.user_lastName);
        user.setBirthDate(Constants.user_birthDate);
        user.setRoles(Constants.user_roles);
        user.setLifeState(LifeState.CREATED);
        user.setCreatedAt(Constants.createdAt);

        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));

        User gotUser = userService.getById(1L);

        assertEquals(1L, gotUser.getId());
        assertEquals(Constants.user_name, gotUser.getName());
        assertEquals(Constants.user_username, gotUser.getUsername());
        assertEquals(Constants.user_lastName, gotUser.getLastName());
        assertEquals(Constants.user_birthDate, gotUser.getBirthDate());
        assertEquals(Constants.user_roles, gotUser.getRoles());
        assertEquals(LifeState.CREATED, gotUser.getLifeState());
        assertEquals(LifeState.CREATED.toString(), gotUser.getLifeStateDescription());
        assertEquals(Constants.createdAt, gotUser.getCreatedAt());
    }

    @Test
    void create() {
        User user = new User();
        user.setId(1L);
        user.setName(Constants.user_name);
        user.setUsername(Constants.user_username);
        user.setLastName(Constants.user_lastName);
        user.setBirthDate(Constants.user_birthDate);
        user.setRoles(Constants.user_roles);

        when(userRepository.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());

        User newUser = userService.create(user);

        assertEquals(1L, newUser.getId());
        assertEquals(Constants.user_name, newUser.getName());
        assertEquals(Constants.user_username, newUser.getUsername());
        assertEquals(Constants.user_lastName, newUser.getLastName());
        assertEquals(Constants.user_birthDate, newUser.getBirthDate());
        assertEquals(Constants.user_roles, newUser.getRoles());
        assertEquals(LifeState.CREATED, newUser.getLifeState());
        assertEquals(LifeState.CREATED.toString(), newUser.getLifeStateDescription());
        assertNotNull(newUser.getCreatedAt());
    }

    @Test
    void update() {
        // TODO: Implement this
    }

    @Test
    void trash() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName(Constants.user_name);
        user.setUsername(Constants.user_username);
        user.setLastName(Constants.user_lastName);
        user.setBirthDate(Constants.user_birthDate);
        user.setRoles(Constants.user_roles);

        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());

        User trashedUser = userService.trash(1L);

        assertEquals(1L, trashedUser.getId());
        assertEquals(Constants.user_name, trashedUser.getName());
        assertEquals(Constants.user_username, trashedUser.getUsername());
        assertEquals(Constants.user_lastName, trashedUser.getLastName());
        assertEquals(Constants.user_birthDate, trashedUser.getBirthDate());
        assertEquals(Constants.user_roles, trashedUser.getRoles());
        assertEquals(LifeState.TRASHED, trashedUser.getLifeState());
        assertEquals(LifeState.TRASHED.toString(), trashedUser.getLifeStateDescription());
        assertNotNull(trashedUser.getTrashedAt());
    }

    @Test
    void trashNotFound() {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            userService.trash(1L);
        });

        assertEquals(exception.getMessage(), StatusCodesMessages.STATUS_CODE_400);
    }

    @Test
    void remove() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName(Constants.user_name);
        user.setUsername(Constants.user_username);
        user.setLastName(Constants.user_lastName);
        user.setBirthDate(Constants.user_birthDate);
        user.setRoles(Constants.user_roles);

        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());

        User trashedUser = userService.remove(1L);

        assertEquals(1L, trashedUser.getId());
        assertEquals(Constants.user_name, trashedUser.getName());
        assertEquals(Constants.user_username, trashedUser.getUsername());
        assertEquals(Constants.user_lastName, trashedUser.getLastName());
        assertEquals(Constants.user_birthDate, trashedUser.getBirthDate());
        assertEquals(Constants.user_roles, trashedUser.getRoles());
        assertEquals(LifeState.REMOVED, trashedUser.getLifeState());
        assertEquals(LifeState.REMOVED.toString(), trashedUser.getLifeStateDescription());
        assertNotNull(trashedUser.getRemovedAt());
    }

    @Test
    void removeNotFound() {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            userService.remove(1L);
        });

        assertEquals(exception.getMessage(), StatusCodesMessages.STATUS_CODE_400);
    }
}