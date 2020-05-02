package com.leito.talentresourceplanning.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leito.talentresourceplanning.controller.util.Mappings;
import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.request.user.CreateUserRequest;
import com.leito.talentresourceplanning.service.UserService;
import com.leito.talentresourceplanning.testutils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @MockBean
    UserService service;

    @Test
    void getAll() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setName(Constants.user_name);
        user1.setUsername(Constants.user_username);
        user1.setLastName(Constants.user_lastName);
        user1.setBirthDate(Constants.user_birthDate);
        user1.setRoles(Constants.user_roles);
        user1.setLifeState(LifeState.CREATED);
        user1.setCreatedAt(Constants.createdAt);
        user1.setModifiedAt(Constants.modifiedAt);

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

        when(service.getAll()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get(Mappings.USERS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value(Constants.user_name))
                .andExpect(jsonPath("$[0].lifeState").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$[0].lifeStateDescription").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$[0].createdAt").value(Constants.createdAt.toString()))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value(Constants.user_name))
                .andExpect(jsonPath("$[1].lifeState").value(LifeState.ACTIVATED.toString()))
                .andExpect(jsonPath("$[1].lifeStateDescription").value("ACTIVATED"))
                .andExpect(jsonPath("$[1].createdAt").value(Constants.createdAt.toString()));
    }

    @Test
    void update() throws Exception {
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
        user.setLifeState(LifeState.REMOVED);
        user.setCreatedAt(Constants.createdAt);
        user.setModifiedAt(Constants.modifiedAt);
        user.setTrashedAt(Constants.trashedAt);

        when(service.getById(any(Long.class))).thenReturn(user);

        mockMvc.perform(post(Mappings.USERS + Mappings.TRASH.replace("{id}", "1")))
                .andExpect(status().isOk());
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
        user.setLifeState(LifeState.REMOVED);
        user.setCreatedAt(Constants.createdAt);
        user.setModifiedAt(Constants.modifiedAt);
        user.setTrashedAt(Constants.trashedAt);
        user.setRemovedAt(Constants.removedAt);

        when(service.getById(any(Long.class))).thenReturn(user);

        mockMvc.perform(post(Mappings.USERS + Mappings.REMOVE.replace("{id}", "1")))
                .andExpect(status().isOk());
    }

    @Test
    void getItem() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName(Constants.user_name);
        user.setUsername(Constants.user_username);
        user.setLastName(Constants.user_lastName);
        user.setBirthDate(Constants.user_birthDate);
        user.setRoles(Constants.user_roles);
        user.setLifeState(LifeState.REMOVED);
        user.setCreatedAt(Constants.createdAt);
        user.setModifiedAt(Constants.modifiedAt);
        user.setTrashedAt(Constants.trashedAt);
        user.setRemovedAt(Constants.removedAt);

        when(service.getById(any(Long.class))).thenReturn(user);

        mockMvc.perform(get(Mappings.USERS + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value(Constants.user_name))
                .andExpect(jsonPath("$.username").value(Constants.user_username))
                .andExpect(jsonPath("$.lastName").value(Constants.user_lastName))
                .andExpect(jsonPath("$.birthDate").value(Constants.user_birthDate.toString()))
                .andExpect(jsonPath("$", hasKey("roles")))
                .andExpect(jsonPath("$.lifeState").value(LifeState.REMOVED.toString()))
                .andExpect(jsonPath("$.lifeStateDescription").value(LifeState.REMOVED.toString()))
                .andExpect(jsonPath("$.createdAt").value(Constants.createdAt.toString()))
                .andExpect(jsonPath("$.modifiedAt").value(Constants.modifiedAt.toString()))
                .andExpect(jsonPath("$.trashedAt").value(Constants.trashedAt.toString()))
                .andExpect(jsonPath("$.removedAt").value(Constants.removedAt.toString()));
    }

    @Test
    void create() throws Exception {
        CreateUserRequest request = new CreateUserRequest();
        request.setName(Constants.user_name);
        request.setUsername(Constants.user_username);
        request.setLastName(Constants.user_lastName);

        User user = new User();
        user.setId(1L);
        user.setName(Constants.user_name);
        user.setUsername(Constants.user_username);
        user.setLastName(Constants.user_lastName);
        user.setBirthDate(Constants.user_birthDate);
        user.setRoles(Constants.user_roles);
        user.setLifeState(LifeState.CREATED);
        user.setCreatedAt(Constants.createdAt);

        when(service.create(any(User.class))).thenReturn(user);

        mockMvc.perform(post(Mappings.USERS)
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value(Constants.user_name))
                .andExpect(jsonPath("$.username").value(Constants.user_username))
                .andExpect(jsonPath("$.lastName").value(Constants.user_lastName))
                .andExpect(jsonPath("$.birthDate").value(Constants.user_birthDate.toString()))
                .andExpect(jsonPath("$.lifeState").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$.lifeStateDescription").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$.createdAt").value(Constants.createdAt.toString()));
    }
}