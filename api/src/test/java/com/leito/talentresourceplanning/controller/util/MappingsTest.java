package com.leito.talentresourceplanning.controller.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MappingsTest {

    @Test
    public void testMappings() {
        // Commons
        assertEquals(Mappings.URL_SEPARATOR, "/");
        assertEquals(Mappings.ID_PARAMETER, "/{id}");
        assertEquals(Mappings.TRASH, Mappings.ID_PARAMETER + "/trash");
        assertEquals(Mappings.REMOVE, Mappings.ID_PARAMETER + "/remove");

        // Users
        assertEquals(Mappings.USERS_LOGIN, "/login");
        assertEquals(Mappings.USERS_LOGOUT, "/logout");
        assertEquals(Mappings.USERS_REGISTER, "/register");

        assertEquals(Mappings.USERS, "/users");

        // Roles
        assertEquals(Mappings.ROLES, "/roles");

        // Roles
        assertEquals(Mappings.PERMISSIONS, "/permissions");
    }

}