import React from "react";
import TableValue from "./TableValue";
import { Link } from "react-router-dom";

export default function CrudTable(props) {
    const { content, columns } = props;

    return (
        <table className="table table-hover thead-dark">
            <thead>
                <tr className="table-primary">
                    {columns.map((column, i) => (
                        <th key={i}>{column.displayText || column.name}</th>
                    ))}
                    <td></td>
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
                            <td>
                                <Link to="#" onClick={item.trash} className="text-danger">
                                    Remove
                                </Link>
                            </td>
                        </tr>
                    ))}
            </tbody>
        </table>
    );
}
