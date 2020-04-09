import { all } from "redux-saga/effects";

import users from "./usersSagas";

export default function* rootSaga() {
    yield all([users()]);
}
