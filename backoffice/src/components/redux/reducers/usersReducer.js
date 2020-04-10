import { typesActions } from "../actions/typesActions";

const initialState = {
    users: [],
    loading: false,
    error: null
};

export default function (state = initialState, { type, users, user, error }) {
    switch (type) {
        case typesActions.START_GETTING_USERS:
            return {
                ...state,
                loading: true
            };
        case typesActions.SUCCESS_GETTING_USERS:
            return {
                ...state,
                loading: false,
                users: users,
                error: null
            };
        case typesActions.ERROR_GETTING_USERS:
            return {
                ...state,
                loading: false,
                error: error
            };
            case typesActions.START_GETTING_USER:
            return {
                ...state,
                loading: true
            };
        case typesActions.SUCCESS_GETTING_USER:
            return {
                ...state,
                loading: false,
                user: user,
                error: null
            };
        case typesActions.ERROR_GETTING_USER:
            return {
                ...state,
                loading: false,
                error: error
            };
        default:
            return state;
    }
}
