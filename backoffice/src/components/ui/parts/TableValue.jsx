import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import classNames from "classnames";

export default function TableValue(props) {
    const { item, column } = props;
    const [editing, setEditing] = useState(false);
    const [value, setValue] = useState();
    const [inputValue, setInputValue] = useState();
    const [template, setTemplate] = useState();

    let newValue;

    if (["string", "number"].includes(typeof item[column.name])) {
        newValue = item[column.name];
    }

    if (["boolean"].includes(typeof item[column.name])) {
        newValue = item[column.name] ? "Yes" : "No";
    }

    useEffect(() => {
        setValue(newValue);

        const editValue = e => {
            setEditing(true);
            setInputValue(e.target.innerText);
        };

        const cancelEditValue = () => {
            setEditing(false);
        };

        const onChange = e => {
            setInputValue(e.target.value);
        };

        const onSubmit = e => {
            alert("TODO: modify element");
            e.preventDefault();
        };

        setTemplate(
            <div>
                <form onSubmit={onSubmit}>
                    <input
                        className={classNames({
                            "position-absolute": true,
                            transparent: !editing
                        })}
                        onBlur={cancelEditValue}
                        onChange={onChange}
                        value={inputValue}
                    />
                </form>
                <span
                    onDoubleClick={editValue}
                    className={classNames({
                        transparent: editing
                    })}>
                    {value}
                </span>
            </div>
        );

        if (column.link) {
            let linkTo = "/";
            if (typeof column.link === "function") {
                linkTo = column.link(item);
            } else if (typeof column.link === "string") {
                linkTo = column.link;
            }
            setTemplate(template => <Link to={linkTo}>{template}</Link>);
        }
    }, [value, inputValue, editing, column, item, newValue]);

    return <>{template}</>;
}
