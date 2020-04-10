import React, { useEffect } from "react";
import { connect } from "react-redux";
import { useParams } from "react-router-dom";

import URLMapping from "utils/routes";
import { startGettingUser } from "components/redux/actions/usersActions";
import Error from "components/ui/pages/Error";
import Title from "components/ui/parts/Title";
import Table from "components/ui/parts/Table";

function UserDetail(props) {
    const { user, loading, error, getUser } = props;
    const { id } = useParams();

    useEffect(() => {
        getUser(id);
    }, [id, getUser]);

    if (error) {
        return <Error />;
    }

    return (
        <>
            <Title title="User detail" backUrl={URLMapping.USERS} loading={loading} />
            <Table
                content={user}
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
    user: state.usersReducer.user || {},
    error: state.usersReducer.error,
    loading: state.usersReducer.loading
});

const mapDispatchToProps = dispatch => ({
    getUser: id => dispatch(startGettingUser(id))
});

export default connect(mapStateToProps, mapDispatchToProps)(UserDetail);
