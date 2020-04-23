import React from "react";

import { NavLink, useHistory } from "react-router-dom";
import URLMapping from "utils/routes";

export default function Header() {
    const history = useHistory();

    const logout = () => {
        localStorage.removeItem("isLogged");
        history.push(URLMapping.LOGIN);
    };

    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <NavLink className="navbar-brand" to={URLMapping.HOME}>
                Talent Resource Planning BO
            </NavLink>
            <button
                className="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarColor02"
                aria-controls="navbarColor02"
                aria-expanded="false"
                aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarColor02">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item">
                        <NavLink exact activeClassName="active" className="nav-link" to={URLMapping.HOME}>
                            Home <span className="sr-only">(current)</span>
                        </NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink activeClassName="active" className="nav-link" to={URLMapping.USERS}>
                            Users
                        </NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink activeClassName="active" className="nav-link" to={URLMapping.ROLES}>
                            Roles
                        </NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink activeClassName="active" className="nav-link" to={URLMapping.PERMISSIONS}>
                            Permissions
                        </NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink activeClassName="active" className="nav-link" to="/not-found">
                            Not Found
                        </NavLink>
                    </li>
                </ul>
                <ul className="navbar-nav my-2 my-lg-0">
                    <li className="nav-item">
                        <button className="btn" onClick={logout}>
                            Logout
                        </button>
                    </li>
                </ul>
            </div>
        </nav>
    );
}
