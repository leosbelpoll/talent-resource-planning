import React from "react";
import { Route, Switch } from "react-router-dom";

import URLMapping from "utils/routes";
import Home from "components/ui/pages/Home";
import NotFound from "components/ui/pages/NotFound";
import Header from "components/ui/parts/Header";
import UserList from "components/business/User/UserList";
import UserDetail from "components/business/User/UserDetail";

export default function InternalRoutes() {
    return (
        <>
            <Header />
            <div className="container">
                <Switch>
                    <Route exact path={URLMapping.HOME} component={Home} />
                    <Route exact path={URLMapping.USERS} component={UserList} />
                    <Route exact path={URLMapping.USER_DETAIL} component={UserDetail} />
                    <Route path="*" component={NotFound} />
                </Switch>
            </div>
        </>
    );
}
