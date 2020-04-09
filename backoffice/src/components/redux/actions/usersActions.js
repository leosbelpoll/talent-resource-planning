import { typesActions } from "./typesActions";

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
