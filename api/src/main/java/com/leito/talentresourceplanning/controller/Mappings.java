package com.leito.talentresourceplanning.controller;

public class Mappings {

    private Mappings () {}

    // Commons
    public static final String URL_SEPARATOR = "/";
    public static final String ID_PARAMETER = "/{id}";
    public static final String TRASH = ID_PARAMETER + "/trash";
    public static final String REMOVE = ID_PARAMETER + "/remove";

    // Users
    public static final String USERS_LOGIN = "/login";
    public static final String USERS_LOGOUT = "/logout";
    public static final String USERS_REGISTER = "/register";

    public static final String USERS = "/users";

    // Roles
    public static final String ROLES = "/roles";

    // Roles
    public static final String PERMISSIONS = "/permissions";
}
