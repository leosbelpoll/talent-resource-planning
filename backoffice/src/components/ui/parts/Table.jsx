import React from "react";

import VerticalTable from "./VerticalTable";
import HorizontalTable from "./HorizontalTable";
import { getColumns } from "utils/tableUtils";
import CrudTable from "./CrudTable";

export default function Table(props) {
    const { type, content, onlyColumns, excludeColumns } = props;

    let columns = [];

    if (onlyColumns) {
        columns = onlyColumns;
    } else {
        columns = getColumns(content, excludeColumns || []);
    }

    const newProps = {
        ...props,
        columns,
        content
    };

    if (type === "crud") {
        return <CrudTable {...newProps} />;
    }

    if (type === "horizontal" || content instanceof Array) {
        return <HorizontalTable {...newProps} />;
    }

    if (type === "vertical" || content instanceof Object) {
        return <VerticalTable {...newProps} />;
    }
}
