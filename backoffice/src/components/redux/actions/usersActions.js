import { typesActions } from "./typesActions";

// User list

export const startGettingUsers = () => ({
    type: typesActions.START_GETTING_USERS
});

export const successGettingUsers = payload => ({
    type: typesActions.SUCCESS_GETTING_USERS,
    ...payload
});

export const errorGettingUsers = payload => ({
    type: typesActions.ERROR_GETTING_USERS,
    ...payload
});


// User detail

export const startGettingUser = id => ({
    type: typesActions.START_GETTING_USER,
    id
});

export const successGettingUser = payload => ({
    type: typesActions.SUCCESS_GETTING_USER,
    ...payload
});

export const errorGettingUser = payload => ({
    type: typesActions.ERROR_GETTING_USER,
    ...payload
});
