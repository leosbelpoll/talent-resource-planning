import { roleTypes } from "../actions/rolesActions";

const initialState = {
    roles: [],
    loading: false,
    error: null
};

export default function (state = initialState, { type, roles, role, error }) {
    switch (type) {
        case roleTypes.START_GETTING_ROLES:
            return {
                ...state,
                loading: true
            };
        case roleTypes.SUCCESS_GETTING_ROLES:
            return {
                ...state,
                loading: false,
                roles: roles,
                error: null
            };
        case roleTypes.ERROR_GETTING_ROLES:
            return {
                ...state,
                loading: false,
                error: error
            };
            case roleTypes.START_GETTING_ROLE:
            return {
                ...state,
                loading: true
            };
        case roleTypes.SUCCESS_GETTING_ROLE:
            return {
                ...state,
                loading: false,
                role: role,
                error: null
            };
        case roleTypes.ERROR_GETTING_ROLE:
            return {
                ...state,
                loading: false,
                error: error
            };
        default:
            return state;
    }
}
