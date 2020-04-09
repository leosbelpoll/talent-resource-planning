import { createStore, applyMiddleware, compose } from "redux";
import reduxSaga from "redux-saga";

import rootReducer from "components/redux/reducers";
import rootSaga from "components/redux/sagas";

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const sagaMiddleware = reduxSaga();
const store =
    process.env.NODE_ENV === "production"
        ? createStore(rootReducer, applyMiddleware(sagaMiddleware))
        : createStore(rootReducer, composeEnhancers(applyMiddleware(sagaMiddleware)));

export default {
    ...store,
    runSaga: sagaMiddleware.run(rootSaga)
};
