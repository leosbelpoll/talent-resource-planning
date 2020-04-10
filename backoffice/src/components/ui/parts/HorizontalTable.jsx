import React from "react";

export default function HorizontalTable(props) {
    const { content, columns, getValue } = props;

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
                                <td key={i}>{getValue(item, column)}</td>
                            ))}
                        </tr>
                    ))}
            </tbody>
        </table>
    );
}
