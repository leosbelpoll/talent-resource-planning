package com.leito.talentresourceplanning.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leito.talentresourceplanning.controller.util.Mappings;
import com.leito.talentresourceplanning.entity.LifeState;
import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.request.permission.CreatePermissionRequest;
import com.leito.talentresourceplanning.service.PermissionService;
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

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PermissionControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @MockBean
    PermissionService service;

    @Test
    void getAll() throws Exception {
        Permission permission1 = new Permission();
        permission1.setId(1L);
        permission1.setName(Constants.permission_name);
        permission1.setDescription(Constants.permission_description);
        permission1.setRoles(Constants.permission_roles);
        permission1.setLifeState(LifeState.CREATED);
        permission1.setCreatedAt(Constants.createdAt);
        permission1.setModifiedAt(Constants.modifiedAt);
        permission1.setTrashedAt(Constants.trashedAt);

        Permission permission2 = new Permission();
        permission2.setId(2L);
        permission2.setName(Constants.permission_name);
        permission2.setDescription(Constants.permission_description);
        permission2.setRoles(Constants.permission_roles);
        permission2.setLifeState(LifeState.ACTIVATED);
        permission2.setCreatedAt(Constants.createdAt);
        permission2.setModifiedAt(Constants.modifiedAt);
        permission2.setTrashedAt(Constants.trashedAt);


        when(service.getAll()).thenReturn(Arrays.asList(permission1, permission2));

        mockMvc.perform(get(Mappings.PERMISSIONS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value(Constants.permission_name))
                .andExpect(jsonPath("$[0].description").value(Constants.permission_description))
                .andExpect(jsonPath("$[0].lifeState").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$[0].lifeStateDescription").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$[0].createdAt").value(Constants.createdAt.toString()))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value(Constants.permission_name))
                .andExpect(jsonPath("$[1].description").value(Constants.permission_description))
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
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setName(Constants.permission_name);
        permission.setDescription(Constants.permission_description);
        permission.setRoles(Constants.permission_roles);
        permission.setLifeState(LifeState.TRASHED);
        permission.setCreatedAt(Constants.createdAt);
        permission.setModifiedAt(Constants.modifiedAt);
        permission.setTrashedAt(Constants.trashedAt);

        when(service.getById(any(Long.class))).thenReturn(permission);

        mockMvc.perform(post(Mappings.PERMISSIONS + Mappings.TRASH.replace("{id}", "1")))
                .andExpect(status().isOk());
    }

    @Test
    void remove() throws Exception {
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setName(Constants.permission_name);
        permission.setDescription(Constants.permission_description);
        permission.setRoles(Constants.permission_roles);
        permission.setLifeState(LifeState.REMOVED);
        permission.setCreatedAt(Constants.createdAt);
        permission.setModifiedAt(Constants.modifiedAt);
        permission.setTrashedAt(Constants.trashedAt);
        permission.setRemovedAt(Constants.removedAt);

        when(service.getById(any(Long.class))).thenReturn(permission);

        mockMvc.perform(post(Mappings.PERMISSIONS + Mappings.REMOVE.replace("{id}", "1")))
                .andExpect(status().isOk());
    }

    @Test
    void getItem() throws Exception {
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setName(Constants.permission_name);
        permission.setDescription(Constants.permission_description);
        permission.setRoles(Constants.permission_roles);
        permission.setLifeState(LifeState.REMOVED);
        permission.setCreatedAt(Constants.createdAt);
        permission.setModifiedAt(Constants.modifiedAt);
        permission.setTrashedAt(Constants.trashedAt);
        permission.setRemovedAt(Constants.removedAt);

        when(service.getById(any(Long.class))).thenReturn(permission);

        mockMvc.perform(get(Mappings.PERMISSIONS + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value(Constants.permission_name))
                .andExpect(jsonPath("$.description").value(Constants.permission_description))
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
        CreatePermissionRequest request = new CreatePermissionRequest();
        request.setName(Constants.permission_name);
        request.setDescription(Constants.permission_description);

        Permission permission = new Permission();
        permission.setId(1L);
        permission.setName(request.getName());
        permission.setDescription(request.getDescription());
        permission.setLifeState(LifeState.CREATED);
        permission.setCreatedAt(Constants.createdAt);

        when(service.create(any(Permission.class))).thenReturn(permission);

        mockMvc.perform(post(Mappings.PERMISSIONS)
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value(Constants.permission_name))
                .andExpect(jsonPath("$.description").value(Constants.permission_description))
                .andExpect(jsonPath("$.lifeState").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$.lifeStateDescription").value(LifeState.CREATED.toString()))
                .andExpect(jsonPath("$.createdAt").value(Constants.createdAt.toString()));
    }
}