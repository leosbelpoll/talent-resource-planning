import React from "react";
import TableValue from "./TableValue";

export default function VerticalTable(props) {
    const { content, columns } = props;

    return (
        <table className="table table-hover">
            <tbody>
                {columns.map((column, i) => (
                    <tr key={i}>
                        <th>{column.displayText || column.name}</th>
                        <td>
                            <TableValue item={content} column={column} />
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}
