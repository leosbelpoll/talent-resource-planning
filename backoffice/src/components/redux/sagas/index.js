import { all } from "redux-saga/effects";

import users from "./usersSagas";
import roles from "./rolesSagas";
import permissions from "./permissionsSagas";

export default function* rootSaga() {
    yield all([
        users(),
        roles(),
        permissions()
    ]);
}
