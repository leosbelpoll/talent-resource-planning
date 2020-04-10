import { put, call, takeLatest } from "redux-saga/effects";
import { roleTypes } from "../actions/rolesActions";
import apiCall from "utils/api";

export function* getRoles() {
    try {
        const roles = yield call(apiCall, `http://localhost:7070/roles`);
        yield put({
            type: roleTypes.SUCCESS_GETTING_ROLES,
            roles
        });
    } catch (error) {
        yield put({
            type: roleTypes.ERROR_GETTING_ROLES,
            error
        });
    }
}

export function* getRole({ id }) {
    try {
        const role = yield call(apiCall, `http://localhost:7070/roles/${id}`);
        yield put({
            type: roleTypes.SUCCESS_GETTING_ROLE,
            role
        });
    } catch (error) {
        yield put({
            type: roleTypes.ERROR_GETTING_ROLE,
            error
        });
    }
}

// Watchers

export default function* roles() {
    yield takeLatest(roleTypes.START_GETTING_ROLES, getRoles);
    yield takeLatest(roleTypes.START_GETTING_ROLE, getRole);
}
