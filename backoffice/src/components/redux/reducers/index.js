import { combineReducers } from "redux";
import usersReducer from "./usersReducer";
import rolesReducer from "./rolesReducer";
import permissionsReducer from "./permissionsReducer";

export default combineReducers({
    usersReducer,
    rolesReducer,
    permissionsReducer
});
