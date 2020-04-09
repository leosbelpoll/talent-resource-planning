import { put, call, takeLatest } from "redux-saga/effects";
import { typesActions } from "../actions/typesActions";
import apiCall from "utils/api";

export function* getUsers() {
    try {
        const users = yield call(apiCall, "http://localhost:7070/users");
        yield put({
            type: typesActions.SUCCESS_GETTING_USERS,
            users
        });
    } catch (error) {
        yield put({
            type: typesActions.ERROR_GETTING_USERS,
            error
        });
    }
}

// Watchers

export default function* users() {
    yield takeLatest(typesActions.START_GETTING_USERS, getUsers);
}
