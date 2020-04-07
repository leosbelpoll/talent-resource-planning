-- TALENT permissions

INSERT INTO roles (name, description, life_state, life_state_description, created_at) VALUES ('TALENT', 'TALENT description', 2, 'DEFAULT', GETDATE());

INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('LOGIN', 'LOGIN description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('LOGOUT', 'LOGOUT description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('VIEW_PROFILE', 'VIEW_PROFILE description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('EDIT_PROFILE', 'EDIT_PROFILE description', 2, 'DEFAULT', GETDATE());

INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 1);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 2);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 3);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 4);

-- ADMINISTRATOR permissions

INSERT INTO roles (name, description, life_state, life_state_description, created_at) VALUES ('ADMINISTRATOR', 'ADMINISTRATOR description', 2, 'DEFAULT', GETDATE());

INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('LIST_USERS', 'LIST_USERS description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('GET_USER', 'GET_USER description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('CREATE_USER', 'CREATE_USER description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('UPDATE_USER', 'UPDATE_USER description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('ACTIVATE_USER', 'ACTIVATE_USER description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('DEACTIVATE_USER', 'DEACTIVATE_USER description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('SUSPEND_USER', 'SUSPEND_USER description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('UNSUSPEND_USER', 'UNSUSPEND_USER description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('BLOCK_USER', 'BLOCK_USER description', 2, 'DEFAULT', GETDATE());
INSERT INTO permissions (name, description, life_state, life_state_description, created_at) VALUES ('UNBLOK_USER', 'UNBLOK_USER description', 2, 'DEFAULT', GETDATE());

INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 5);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 6);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 7);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 8);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 9);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 10);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 11);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 12);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 13);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 14);

INSERT INTO sub_roles (role_id, subrole_id) VALUES (1, 2);


-- ADMINISTRATOR user

INSERT INTO users (username, password, name, last_name, birth_date, life_state, life_state_description, created_at) VALUES ('admin', 'admin', 'Robert', 'Artist', '1990-09-26 12:28:10', 2, 'DEFAULT', GETDATE());

INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
