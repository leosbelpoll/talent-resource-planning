import React from "react";

import useLogged from "components/hooks/useLogged";
import InternalRoutes from "./InternalRoutes";
import ExternalRoutes from "./ExternalRoutes";

export default function Routes() {
    const logged = useLogged();

    return logged ? <InternalRoutes /> : <ExternalRoutes />;
}
