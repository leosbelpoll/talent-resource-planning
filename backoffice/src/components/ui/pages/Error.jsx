import React from "react";

export default function Error(props) {
    return (
        <div className="text-center mt-5">
            <h1>Error: {JSON.stringify(props.error)}</h1>
        </div>
    );
}
