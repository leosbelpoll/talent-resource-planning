import React, { useEffect } from "react";
import { connect } from "react-redux";

import URLMapping from "utils/routes";
import { startGettingRoles } from "components/redux/actions/rolesActions";
import Error from "components/ui/pages/Error";
import Title from "components/ui/parts/Title";
import Table from "components/ui/parts/Table";

function RoleList(props) {
    const { roles, loading, error, getRoles } = props;

    useEffect(() => {
        getRoles();
    }, [getRoles]);

    if (error) {
        return <Error />;
    }

    return (
        <>
            <Title title="Role list" loading={loading} />
            <Table
                type="crud"
                content={roles}
                onlyColumns={[
                    {
                        name: "name",
                        link: item => `${URLMapping.ROLES}/${item.id}`
                    },
                    {
                        name: "description"
                    }
                ]}
            />
        </>
    );
}

const mapStateToProps = state => ({
    roles: state.rolesReducer.roles || [],
    error: state.rolesReducer.error,
    loading: state.rolesReducer.loading
});

const mapDispatchToProps = dispatch => ({
    getRoles: () => dispatch(startGettingRoles())
});

export default connect(mapStateToProps, mapDispatchToProps)(RoleList);
