import React from "react";
import { Route, Redirect, Switch } from "react-router-dom";

import URLMapping from "utils/routes";
import UserRegister from "components/business/User/UserRegister";
import UserLogin from "components/business/User/UserLogin";
import NotFound from "components/ui/pages/NotFound";

export default function ExternalRoutes() {
    return (
        <Switch>
            <Route exact path={URLMapping.LOGIN} component={UserLogin} />
            <Route exact path={URLMapping.REGISTER} component={UserRegister} />
            <Route path="*">
                <NotFound />
            </Route>
        </Switch>
    );
}
