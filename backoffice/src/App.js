import React from "react";
import { Provider } from "react-redux";
import { BrowserRouter as Router } from "react-router-dom";

import store from "components/redux/store";
import Routes from "components/app/Routes";

export default function App() {
    return (
        <Provider store={store}>
            <Router>
                <Routes />
            </Router>
        </Provider>
    );
}
