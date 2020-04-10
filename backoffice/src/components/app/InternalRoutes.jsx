import React from "react";
import { Route, Switch } from "react-router-dom";

import URLMapping from "utils/routes";
import Home from "components/ui/pages/Home";
import NotFound from "components/ui/pages/NotFound";
import Header from "components/ui/parts/Header";

// Users
import UserList from "components/business/User/UserList";
import UserDetail from "components/business/User/UserDetail";

// Roles
import RoleList from "components/business/Role/RoleList";
import RoleDetail from "components/business/Role/RoleDetail";

// Permissions
import PermissionList from "components/business/Permission/PermissionList";
import PermissionDetail from "components/business/Permission/PermissionDetail";

export default function InternalRoutes() {
    return (
        <>
            <Header />
            <div className="container">
                <Switch>
                    {/* Front */}
                    <Route exact path={URLMapping.HOME} component={Home} />

                    {/* Users */}
                    <Route exact path={URLMapping.USERS} component={UserList} />
                    <Route exact path={URLMapping.USER_DETAIL} component={UserDetail} />

                    {/* Roles */}
                    <Route exact path={URLMapping.ROLES} component={RoleList} />
                    <Route exact path={URLMapping.ROLE_DETAIL} component={RoleDetail} />

                    {/* Permissions */}
                    <Route exact path={URLMapping.PERMISSIONS} component={PermissionList} />
                    <Route exact path={URLMapping.PERMISSION_DETAIL} component={PermissionDetail} />

                    {/* NotFound */}
                    <Route path="*" component={NotFound} />
                </Switch>
            </div>
        </>
    );
}
