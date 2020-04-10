import { put, call, takeLatest } from "redux-saga/effects";
import { userTypes } from "../actions/usersActions";
import apiCall from "utils/api";

export function* getUsers() {
    try {
        const users = yield call(apiCall, `http://localhost:7070/users`);
        yield put({
            type: userTypes.SUCCESS_GETTING_USERS,
            users
        });
    } catch (error) {
        yield put({
            type: userTypes.ERROR_GETTING_USERS,
            error
        });
    }
}

export function* getUser({ id }) {
    try {
        const user = yield call(apiCall, `http://localhost:7070/users/${id}`);
        yield put({
            type: userTypes.SUCCESS_GETTING_USER,
            user
        });
    } catch (error) {
        yield put({
            type: userTypes.ERROR_GETTING_USER,
            error
        });
    }
}

// Watchers

export default function* users() {
    yield takeLatest(userTypes.START_GETTING_USERS, getUsers);
    yield takeLatest(userTypes.START_GETTING_USER, getUser);
}
