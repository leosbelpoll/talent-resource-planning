import React from "react";
import TableValue from "./TableValue";

export default function HorizontalTable(props) {
    const { content, columns } = props;

    return (
        <table className="table table-hover thead-dark">
            <thead>
                <tr className="table-primary">
                    {columns.map((column, i) => (
                        <th key={i}>{column.name}</th>
                    ))}
                </tr>
            </thead>
            <tbody>
                {content &&
                    content.map((item, i) => (
                        <tr key={i}>
                            {columns.map((column, i) => (
                                <td key={i}>
                                    <TableValue item={item} column={column} />
                                </td>
                            ))}
                        </tr>
                    ))}
            </tbody>
        </table>
    );
}
