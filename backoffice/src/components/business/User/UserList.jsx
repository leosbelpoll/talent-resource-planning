import React, { useEffect, useState } from "react";
import { connect } from "react-redux";

import { startGettingUsers } from "components/redux/actions/usersActions";
import classNames from "classnames";
import Error from "components/ui/pages/Error";

function UserList(props) {
    useEffect(() => {
        props.getUsers();
    }, []);

    return (
        <>
            {props.error ? (
                <Error error={props.error} />
            ) : (
                <div>
                    <div className="mt-5 mb-5">
                        <h1 className="display-5">User List</h1>
                    </div>
                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th>Fullname</th>
                                <th>Username</th>
                                <th>State</th>
                            </tr>
                        </thead>
                        <tbody>
                            {props.users.map(user => (
                                <tr key={user.id}>
                                    <td>
                                        <span>
                                            {user.name} {user.lastName}
                                        </span>
                                    </td>
                                    <td>{user.username}</td>
                                    <td>
                                        <span
                                            className={classNames({
                                                "badge badge-pill": true,
                                                "badge-success": user.lifeState == "ACTIVATED",
                                                "badge-dark": user.lifeState == "CREATED",
                                                "badge-light": user.lifeState == "REGISTERED",
                                                "badge-warning": user.lifeState == "SUSPENDED",
                                                "badge-danger": user.lifeState == "BLOCKED"
                                            })}>
                                            {user.lifeState}
                                        </span>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            )}
        </>
    );
}

const mapStateToProps = state => ({
    users: state.usersReducer.users || [],
    error: state.usersReducer.error
});

const mapDispatchToProps = dispatch => ({
    getUsers: () => dispatch(startGettingUsers())
});

export default connect(mapStateToProps, mapDispatchToProps)(UserList);
