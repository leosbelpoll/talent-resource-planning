import React, { useEffect } from "react";
import { connect } from "react-redux";
import { useParams } from "react-router-dom";

import URLMapping from "utils/routes";
import { startGettingPermission } from "components/redux/actions/permissionsActions";
import Error from "components/ui/pages/Error";
import Title from "components/ui/parts/Title";
import Table from "components/ui/parts/Table";

function PermissionDetail(props) {
    const { permission, loading, error, getPermission } = props;
    const { id } = useParams();

    useEffect(() => {
        getPermission(id);
    }, [id, getPermission]);

    if (error) {
        return <Error />;
    }

    return (
        <>
            <Title title="Permission detail" backUrl={URLMapping.PERMISSIONS} loading={loading} />
            <Table
                content={permission}
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
    permission: state.permissionsReducer.permission || {},
    error: state.permissionsReducer.error,
    loading: state.permissionsReducer.loading
});

const mapDispatchToProps = dispatch => ({
    getPermission: id => dispatch(startGettingPermission(id))
});

export default connect(mapStateToProps, mapDispatchToProps)(PermissionDetail);
