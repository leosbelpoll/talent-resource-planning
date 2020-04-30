package com.leito.talentresourceplanning.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leito.talentresourceplanning.controller.util.Mappings;
import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.request.role.CreateRoleRequest;
import com.leito.talentresourceplanning.service.RoleService;
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
class RoleControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @MockBean
    RoleService service;

    @Test
    void getAll() throws Exception {
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName(Constants.role_name);
        role1.setDescription(Constants.role_description);
        role1.setUsers(Constants.role_users);
        role1.setPermissions(Constants.role_permissions);
        role1.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        role1.setCreatedAt(Constants.createdAt);
        role1.setModifiedAt(Constants.modifiedAt);
        role1.setTrashedAt(Constants.trashedAt);

        Role role2 = new Role();
        role2.setId(2L);
        role2.setName(Constants.role_name);
        role2.setDescription(Constants.role_description);
        role2.setUsers(Constants.role_users);
        role2.setPermissions(Constants.role_permissions);
        role2.setLifeState(LifeState.ACTIVATED, LifeState.ACTIVATED.toString());
        role2.setCreatedAt(Constants.createdAt);
        role2.setModifiedAt(Constants.modifiedAt);
        role2.setTrashedAt(Constants.trashedAt);


        when(service.getAll()).thenReturn(Arrays.asList(role1, role2));

        mockMvc.perform(get(Mappings.ROLES))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value(Constants.role_name))
                .andExpect(jsonPath("$[0].description").value(Constants.role_description))
                .andExpect(jsonPath("$[0].lifeState").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$[0].lifeStateDescription").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$[0].createdAt").value(Constants.createdAt.toString()))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value(Constants.role_name))
                .andExpect(jsonPath("$[1].description").value(Constants.role_description))
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
        Role role = new Role();
        role.setId(1L);
        role.setName(Constants.role_name);
        role.setDescription(Constants.role_description);
        role.setUsers(Constants.role_users);
        role.setPermissions(Constants.role_permissions);
        role.setLifeState(LifeState.TRASHED, LifeState.TRASHED.toString());
        role.setCreatedAt(Constants.createdAt);
        role.setModifiedAt(Constants.modifiedAt);
        role.setTrashedAt(Constants.trashedAt);

        when(service.getById(any(Long.class))).thenReturn(role);

        mockMvc.perform(post(Mappings.ROLES + Mappings.TRASH.replace("{id}", "1")))
                .andExpect(status().isOk());
    }

    @Test
    void remove() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName(Constants.role_name);
        role.setDescription(Constants.role_description);
        role.setUsers(Constants.role_users);
        role.setPermissions(Constants.role_permissions);
        role.setLifeState(LifeState.REMOVED, LifeState.REMOVED.toString());
        role.setCreatedAt(Constants.createdAt);
        role.setModifiedAt(Constants.modifiedAt);
        role.setTrashedAt(Constants.trashedAt);
        role.setRemovedAt(Constants.removedAt);

        when(service.getById(any(Long.class))).thenReturn(role);

        mockMvc.perform(post(Mappings.ROLES + Mappings.REMOVE.replace("{id}", "1")))
                .andExpect(status().isOk());
    }

    @Test
    void getItem() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName(Constants.role_name);
        role.setDescription(Constants.role_description);
        role.setUsers(Constants.role_users);
        role.setPermissions(Constants.role_permissions);
        role.setLifeState(LifeState.TRASHED, LifeState.TRASHED.toString());
        role.setCreatedAt(Constants.createdAt);
        role.setModifiedAt(Constants.modifiedAt);
        role.setTrashedAt(Constants.trashedAt);

        when(service.getById(any(Long.class))).thenReturn(role);

        mockMvc.perform(get(Mappings.ROLES + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value(Constants.role_name))
                .andExpect(jsonPath("$.description").value(Constants.role_description))
                .andExpect(jsonPath("$", hasKey("users")))
                .andExpect(jsonPath("$", hasKey("permissions")))
                .andExpect(jsonPath("$.lifeState").value(LifeState.TRASHED.toString()))
                .andExpect(jsonPath("$.lifeStateDescription").value(LifeState.TRASHED.toString()))
                .andExpect(jsonPath("$.createdAt").value(Constants.createdAt.toString()))
                .andExpect(jsonPath("$.modifiedAt").value(Constants.modifiedAt.toString()))
                .andExpect(jsonPath("$.trashedAt").value(Constants.trashedAt.toString()));
    }

    @Test
    void create() throws Exception {
        CreateRoleRequest request = new CreateRoleRequest();
        request.setName(Constants.role_name);
        request.setDescription(Constants.role_description);

        Role role = new Role();
        role.setId(1L);
        role.setName(request.getName());
        role.setDescription(request.getDescription());
        role.setLifeState(LifeState.CREATED, LifeState.CREATED.toString());
        role.setCreatedAt(Constants.createdAt);

        when(service.create(any(Role.class))).thenReturn(role);

        mockMvc.perform(post(Mappings.ROLES)
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value(Constants.role_name))
                .andExpect(jsonPath("$.description").value(Constants.role_description))
                .andExpect(jsonPath("$.lifeState").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$.lifeStateDescription").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$.createdAt").value(Constants.createdAt.toString()));
    }
}