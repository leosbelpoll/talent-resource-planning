import React from "react";
import { Link } from "react-router-dom";

import URLMapping from "utils/routes";

export default function Home() {
    return (
        <div className="jumbotron m-5">
            <h3 className="display-4">Welcome</h3>
            <p className="lead">
                This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured
                content or information.
            </p>
            <hr className="my-4" />
            <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
            <p className="lead">
                <Link className="btn btn-primary btn-lg" to={URLMapping.HOME} role="button">
                    Learn more
                </Link>
            </p>
        </div>
    );
}
