import React from "react";

export default function VerticalTable(props) {
    const { content, columns, getValue } = props;

    return (
        <table className="table table-hover">
            <tbody>
                {columns.map((column, i) => (
                    <tr key={i}>
                        <th>{column.name}</th>
                        <td>{getValue(content, column)}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}
