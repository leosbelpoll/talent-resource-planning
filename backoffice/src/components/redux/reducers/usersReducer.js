import { userTypes } from "../actions/usersActions";

const initialState = {
    users: [],
    loading: false,
    error: null
};

export default function (state = initialState, { type, users, user, error }) {
    switch (type) {
        case userTypes.START_GETTING_USERS:
            return {
                ...state,
                loading: true
            };
        case userTypes.SUCCESS_GETTING_USERS:
            return {
                ...state,
                loading: false,
                users: users,
                error: null
            };
        case userTypes.ERROR_GETTING_USERS:
            return {
                ...state,
                loading: false,
                error: error
            };
            case userTypes.START_GETTING_USER:
            return {
                ...state,
                loading: true
            };
        case userTypes.SUCCESS_GETTING_USER:
            return {
                ...state,
                loading: false,
                user: user,
                error: null
            };
        case userTypes.ERROR_GETTING_USER:
            return {
                ...state,
                loading: false,
                error: error
            };
        default:
            return state;
    }
}
