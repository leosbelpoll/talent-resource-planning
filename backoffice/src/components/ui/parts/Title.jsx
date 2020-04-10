import React from "react";
import { Link } from "react-router-dom";

import reload from "images/icons/reload.svg";
import leftShortArrow from "images/icons/left-short-arrow.svg";
import "./Title.scss";

export default function Title(props) {
    const { title, backUrl, loading } = props;

    return (
        <div className="__title">
            <h1 className="display-5">
                {backUrl && (
                    <Link to={backUrl}>
                        <img src={leftShortArrow} alt="Go back" className="icon icon-action" />
                    </Link>
                )}
                {title}
                {loading && <img src={reload} alt="Loading" className="icon spin" />}
            </h1>
        </div>
    );
}
