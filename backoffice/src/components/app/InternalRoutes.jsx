import React from "react";
import { Route, Switch } from "react-router-dom";

import URLMapping from "utils/routes";
import Home from "components/ui/pages/Home";
import NotFound from "components/ui/pages/NotFound";
import Header from "components/ui/parts/Header";
import UserList from "components/business/User/UserList";

export default function InternalRoutes() {
    return (
        <>
            <Header />
            <div className="container">
                <Switch>
                    <Route exact path={URLMapping.HOME}>
                        <Home />
                    </Route>
                    <Route exact path={URLMapping.USERS}>
                        <UserList />
                    </Route>
                    <Route path="*">
                        <NotFound />
                    </Route>
                </Switch>
            </div>
        </>
    );
}
