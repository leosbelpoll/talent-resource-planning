export const startGettingRoles = () => ({
    type: roleTypes.START_GETTING_ROLES
});

export const successGettingRoles = payload => ({
    type: roleTypes.SUCCESS_GETTING_ROLES,
    ...payload
});

export const errorGettingRoles = payload => ({
    type: roleTypes.ERROR_GETTING_ROLES,
    ...payload
});


// Role detail

export const startGettingRole = id => ({
    type: roleTypes.START_GETTING_ROLE,
    id
});

export const successGettingRole = payload => ({
    type: roleTypes.SUCCESS_GETTING_ROLE,
    ...payload
});

export const errorGettingRole = payload => ({
    type: roleTypes.ERROR_GETTING_ROLE,
    ...payload
});

export const roleTypes = {
    START_GETTING_ROLES: "START_GETTING_ROLES",
    SUCCESS_GETTING_ROLES: "SUCCESS_GETTING_ROLES",
    ERROR_GETTING_ROLES: "ERROR_GETTING_ROLES",

    START_GETTING_ROLE: "START_GETTING_ROLE",
    SUCCESS_GETTING_ROLE: "SUCCESS_GETTING_ROLE",
    ERROR_GETTING_ROLE: "ERROR_GETTING_ROLE",
};
