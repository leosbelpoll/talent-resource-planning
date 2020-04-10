import { put, call, takeLatest } from "redux-saga/effects";
import { permissionTypes } from "../actions/permissionsActions";
import apiCall from "utils/api";

export function* getPermissions() {
    try {
        const permissions = yield call(apiCall, `http://localhost:7070/permissions`);
        yield put({
            type: permissionTypes.SUCCESS_GETTING_PERMISSIONS,
            permissions
        });
    } catch (error) {
        yield put({
            type: permissionTypes.ERROR_GETTING_PERMISSIONS,
            error
        });
    }
}

export function* getPermission({ id }) {
    try {
        const permission = yield call(apiCall, `http://localhost:7070/permissions/${id}`);
        yield put({
            type: permissionTypes.SUCCESS_GETTING_PERMISSION,
            permission
        });
    } catch (error) {
        yield put({
            type: permissionTypes.ERROR_GETTING_PERMISSION,
            error
        });
    }
}

// Watchers

export default function* permissions() {
    yield takeLatest(permissionTypes.START_GETTING_PERMISSIONS, getPermissions);
    yield takeLatest(permissionTypes.START_GETTING_PERMISSION, getPermission);
}
