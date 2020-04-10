import React, { useEffect } from "react";
import { connect } from "react-redux";
import { useParams } from "react-router-dom";

import URLMapping from "utils/routes";
import { startGettingRole } from "components/redux/actions/rolesActions";
import Error from "components/ui/pages/Error";
import Title from "components/ui/parts/Title";
import Table from "components/ui/parts/Table";

function RoleDetail(props) {
    const { role, loading, error, getRole } = props;
    const { id } = useParams();

    useEffect(() => {
        getRole(id);
    }, [id, getRole]);

    if (error) {
        return <Error />;
    }

    return (
        <>
            <Title title="Role detail" backUrl={URLMapping.ROLES} loading={loading} />
            <Table
                content={role}
                onlyColumns={[
                    {
                        name: "name"
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
    role: state.rolesReducer.role || {},
    error: state.rolesReducer.error,
    loading: state.rolesReducer.loading
});

const mapDispatchToProps = dispatch => ({
    getRole: id => dispatch(startGettingRole(id))
});

export default connect(mapStateToProps, mapDispatchToProps)(RoleDetail);
