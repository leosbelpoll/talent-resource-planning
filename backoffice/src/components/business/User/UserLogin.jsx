import React from "react";
import { Link, useHistory } from "react-router-dom";

import URLMapping from "utils/routes";
import profileImage from "images/profile-image.png";
import googleIcon from "images/google-icon.png";
import facebookIcon from "images/facebook-icon.png";
import "./UserLogin.scss";

export default function UserLogin(props) {
    let history = useHistory();

    const login = () => {
        localStorage.setItem("isLogged", true);
        history.push(URLMapping.HOME);
    };

    return (
        <div className="__user-login">
            <div className="card center-card">
                <img className="profile-image" src={profileImage} alt="Template icon" />
                <form>
                    <div className="form-group">
                        <input className="form-control" placeholder="Username" required autoFocus />
                    </div>
                    <div className="form-group">
                        <input type="password" className="form-control" placeholder="Password" required />
                    </div>
                    <div className="form-group">
                        <div className="custom-control custom-checkbox">
                            <input type="checkbox" className="custom-control-input" id="remember-me" />
                            <label className="custom-control-label" htmlFor="remember-me">
                                Remember me
                            </label>
                        </div>
                    </div>
                    <button className="btn btn-primary btn-block" onClick={login}>Sign in</button>
                    <div className="text-center m-4">
                        <span>Or login with</span>
                    </div>
                    <div className="form-group social-buttons">
                        <button className="btn" onClick={login}>
                            <img className="facebook-icon icon" src={facebookIcon} alt="Facebook icon" /> Facebook
                        </button>
                        <button className="btn" onClick={login}>
                            <img className="google-icon icon" src={googleIcon} alt="Google icon" /> Google
                        </button>
                    </div>
                    <div className="text-center mt-5">
                        <span>Not a member?</span> <Link to={URLMapping.REGISTER}>Sign up now</Link>
                    </div>
                </form>
            </div>
        </div>
    );
}
