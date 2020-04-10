export const startGettingUsers = () => ({
    type: userTypes.START_GETTING_USERS
});

export const successGettingUsers = payload => ({
    type: userTypes.SUCCESS_GETTING_USERS,
    ...payload
});

export const errorGettingUsers = payload => ({
    type: userTypes.ERROR_GETTING_USERS,
    ...payload
});


// User detail

export const startGettingUser = id => ({
    type: userTypes.START_GETTING_USER,
    id
});

export const successGettingUser = payload => ({
    type: userTypes.SUCCESS_GETTING_USER,
    ...payload
});

export const errorGettingUser = payload => ({
    type: userTypes.ERROR_GETTING_USER,
    ...payload
});

export const userTypes = {
    START_GETTING_USERS: "START_GETTING_USERS",
    SUCCESS_GETTING_USERS: "SUCCESS_GETTING_USERS",
    ERROR_GETTING_USERS: "ERROR_GETTING_USERS",

    START_GETTING_USER: "START_GETTING_USER",
    SUCCESS_GETTING_USER: "SUCCESS_GETTING_USER",
    ERROR_GETTING_USER: "ERROR_GETTING_USER",
};
