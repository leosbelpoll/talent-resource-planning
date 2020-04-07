CREATE TABLE permissions(
    id bigint IDENTITY(1,1) PRIMARY KEY,
    name varchar(255) NOT NULL UNIQUE,
    description varchar(255) NULL,

    -- Base Entity
    life_state int NOT NULL,
    life_state_description varchar(255) NOT NULL,
    created_at datetime NOT NULL,
    modified_at datetime NULL,
    trashed_at datetime NULL,
    removed_at datetime NULL
);

--SET IDENTITY_INSERT permissions ON;

CREATE TABLE roles(
    id bigint IDENTITY(1,1) PRIMARY KEY,
    name varchar(255) NOT NULL UNIQUE,
    description varchar(255) NULL,

    -- Base Entity
    life_state int NOT NULL,
    life_state_description varchar(255) NOT NULL,
    created_at datetime NOT NULL,
    modified_at datetime NULL,
    trashed_at datetime NULL,
    removed_at datetime NULL
);

--SET IDENTITY_INSERT roles ON;

CREATE TABLE roles_permissions(
  role_id bigint NOT NULL,
  permission_id bigint NOT NULL,
  PRIMARY KEY (role_id, permission_id),
  CONSTRAINT fk_roles_permissions_role_id FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT fk_roles_permissions_permission_id FOREIGN KEY (permission_id) REFERENCES permissions (id)
);

CREATE TABLE sub_roles(
  role_id bigint NOT NULL,
  subrole_id bigint NOT NULL,
  PRIMARY KEY (role_id, subrole_id),
  CONSTRAINT fk_sub_roles_role_id FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT fk_sub_roles_key_id FOREIGN KEY (subrole_id) REFERENCES roles (id)
);

CREATE TABLE users(
    id bigint IDENTITY(1,1) PRIMARY KEY,
    username varchar(255) NOT NULL UNIQUE,
    password varchar(255) NULL,
    name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    birth_date varchar(255) NULL,

    -- Base Entity
    life_state int NOT NULL,
    life_state_description varchar(255) NOT NULL,
    created_at datetime NOT NULL,
    modified_at datetime NULL,
    trashed_at datetime NULL,
    removed_at datetime NULL
);

--SET IDENTITY_INSERT users ON;

CREATE TABLE users_roles (
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  PRIMARY KEY (user_id, role_id),
  CONSTRAINT fk_users_roles_user_id FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_users_roles_role_id FOREIGN KEY (role_id) REFERENCES roles (id)
);
