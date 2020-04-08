import React from "react";
import { Link, useHistory } from "react-router-dom";

import URLMapping from "utils/routes";

export default function UserRegister() {
    const history = useHistory();

    const register = () => {
        localStorage.setItem("isLogged", true);
        history.push(URLMapping.HOME);
    };

    return (
        <div className="__user-register">
            <div className="card center-card">
                <h3 className="mb-4">Sign up</h3>
                <form>
                    <div className="form-group">
                        <input className="form-control" placeholder="Username" required autoFocus />
                    </div>
                    <div className="form-group">
                        <input className="form-control" placeholder="Name" required />
                    </div>
                    <div className="form-group">
                        <input className="form-control" placeholder="Last name" required />
                    </div>
                    <div className="form-group">
                        <input type="password" className="form-control" placeholder="Password" required />
                    </div>
                    <div className="form-group">
                        <input type="password" className="form-control" placeholder="Confirm Password" required />
                    </div>
                    <button className="btn btn-primary btn-block" onClick={register}>Sign up</button>
                    <div className="text-center mt-5">
                        <span>Already a member?</span> <Link to={URLMapping.LOGIN}>Login</Link>
                    </div>
                </form>
            </div>
        </div>
    );
}
