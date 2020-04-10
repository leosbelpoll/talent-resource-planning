import { permissionTypes } from "../actions/permissionsActions";

const initialState = {
    permissions: [],
    loading: false,
    error: null
};

export default function (state = initialState, { type, permissions, permission, error }) {
    switch (type) {
        case permissionTypes.START_GETTING_PERMISSIONS:
            return {
                ...state,
                loading: true
            };
        case permissionTypes.SUCCESS_GETTING_PERMISSIONS:
            return {
                ...state,
                loading: false,
                permissions: permissions,
                error: null
            };
        case permissionTypes.ERROR_GETTING_PERMISSIONS:
            return {
                ...state,
                loading: false,
                error: error
            };
            case permissionTypes.START_GETTING_PERMISSION:
            return {
                ...state,
                loading: true
            };
        case permissionTypes.SUCCESS_GETTING_PERMISSION:
            return {
                ...state,
                loading: false,
                permission: permission,
                error: null
            };
        case permissionTypes.ERROR_GETTING_PERMISSION:
            return {
                ...state,
                loading: false,
                error: error
            };
        default:
            return state;
    }
}
