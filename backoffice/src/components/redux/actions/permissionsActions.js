export const startGettingPermissions = () => ({
    type: permissionTypes.START_GETTING_PERMISSIONS
});

export const successGettingPermissions = payload => ({
    type: permissionTypes.SUCCESS_GETTING_PERMISSIONS,
    ...payload
});

export const errorGettingPermissions = payload => ({
    type: permissionTypes.ERROR_GETTING_PERMISSIONS,
    ...payload
});


// Permission detail

export const startGettingPermission = id => ({
    type: permissionTypes.START_GETTING_PERMISSION,
    id
});

export const successGettingPermission = payload => ({
    type: permissionTypes.SUCCESS_GETTING_PERMISSION,
    ...payload
});

export const errorGettingPermission = payload => ({
    type: permissionTypes.ERROR_GETTING_PERMISSION,
    ...payload
});

export const permissionTypes = {
    START_GETTING_PERMISSIONS: "START_GETTING_PERMISSIONS",
    SUCCESS_GETTING_PERMISSIONS: "SUCCESS_GETTING_PERMISSIONS",
    ERROR_GETTING_PERMISSIONS: "ERROR_GETTING_PERMISSIONS",

    START_GETTING_PERMISSION: "START_GETTING_PERMISSION",
    SUCCESS_GETTING_PERMISSION: "SUCCESS_GETTING_PERMISSION",
    ERROR_GETTING_PERMISSION: "ERROR_GETTING_PERMISSION",
};
