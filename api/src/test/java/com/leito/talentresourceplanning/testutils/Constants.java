package com.leito.talentresourceplanning.testutils;

import com.leito.talentresourceplanning.entity.Permission;
import com.leito.talentresourceplanning.entity.Role;
import com.leito.talentresourceplanning.entity.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Constants {

    // BaseEntity

    public final static LocalDate createdAt = LocalDate.of(2020, 4, 20);

    public final static LocalDate modifiedAt = LocalDate.of(2020, 4, 23);

    public final static LocalDate trashedAt = LocalDate.of(2020, 4, 24);

    public final static LocalDate removedAt = LocalDate.of(2020, 4, 25);


    // Users

    public final static String user_username = "fperez";

    public final static String user_textPlainPassword = "Password1";

    public final static String user_name = "Federico";

    public final static String user_lastName = "Pérez";

    public final static LocalDate user_birthDate = LocalDate.of(1988, 6, 17);

    public final static Set<Role> user_roles = new HashSet<>();


    // Roles

    public final static String role_name = "ADMIN";

    public final static String role_description = "App administrator";

    public final static Set<User> role_users = new HashSet<>();

    public final static Set<Permission> role_permissions = new HashSet<>();


    // Permissions

    public final static String permission_name = "ADMIN";

    public final static String permission_description = "App administrator";

    public final static Set<Role> permission_roles = new HashSet<>();

}
