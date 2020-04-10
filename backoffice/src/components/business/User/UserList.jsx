import React, { useEffect } from "react";
import { connect } from "react-redux";

import URLMapping from "utils/routes";
import { startGettingUsers } from "components/redux/actions/usersActions";
import Error from "components/ui/pages/Error";
import Title from "components/ui/parts/Title";
import Table from "components/ui/parts/Table";

function UserList(props) {
    const { users, loading, error, getUsers } = props;

    useEffect(() => {
        getUsers();
    }, [getUsers]);

    if (error) {
        return <Error />;
    }

    return (
        <>
            <Title title="User list" loading={loading} />
            <Table
                content={users}
                onlyColumns={[
                    {
                        name: "name",
                        link: item => `${URLMapping.USERS}/${item.id}`
                    },
                    {
                        name: "lastName"
                    },
                    {
                        name: "username",
                        className: "bg-warning p-1 text-danger"
                    },
                    {
                        name: "lifeState"
                    }
                ]}
            />
        </>
    );
}

const mapStateToProps = state => ({
    users: state.usersReducer.users || [],
    error: state.usersReducer.error,
    loading: state.usersReducer.loading
});

const mapDispatchToProps = dispatch => ({
    getUsers: () => dispatch(startGettingUsers())
});

export default connect(mapStateToProps, mapDispatchToProps)(UserList);
