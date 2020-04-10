import React from "react";

import VerticalTable from "./VerticalTable";
import HorizontalTable from "./HorizontalTable";
import { getColumns } from "utils/tableUtils";
import { Link } from "react-router-dom";

export default function Table(props) {
    const { type, content, onlyColumns, excludeColumns } = props;
    let columns = [];

    if (onlyColumns) {
        columns = onlyColumns;
    } else {
        columns = getColumns(content, excludeColumns || []);
    }

    const getValue = (item, column) => {
        let value;

        if (["string", "number"].includes(typeof item[column.name])) {
            value = item[column.name];
        }

        if (["boolean"].includes(typeof item[column.name])) {
            value = item[column.name] ? "Yes" : "No";
        }

        value = <span className={column.className}>{value}</span>;

        if (column.link) {
            value = <Link to={column.link(item)}>{value}</Link>;
        }

        return value;
    };

    const newProps = {
        columns,
        content,
        getValue
    };

    if (type === "horizontal" || content instanceof Array) {
        return <HorizontalTable {...newProps} />;
    }

    if (type === "vertical" || content instanceof Object) {
        return <VerticalTable {...newProps} />;
    }
}
