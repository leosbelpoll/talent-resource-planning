import React, { useEffect } from "react";
import { connect } from "react-redux";

import URLMapping from "utils/routes";
import { startGettingPermissions } from "components/redux/actions/permissionsActions";
import Error from "components/ui/pages/Error";
import Title from "components/ui/parts/Title";
import Table from "components/ui/parts/Table";

function PermissionList(props) {
    const { permissions, loading, error, getPermissions } = props;

    useEffect(() => {
        getPermissions();
    }, [getPermissions]);

    if (error) {
        return <Error />;
    }

    return (
        <>
            <Title title="Permission list" loading={loading} />
            <Table
                type="crud"
                content={permissions}
                onlyColumns={[
                    {
                        name: "name",
                        link: item => `${URLMapping.PERMISSIONS}/${item.id}`
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
    permissions: state.permissionsReducer.permissions || [],
    error: state.permissionsReducer.error,
    loading: state.permissionsReducer.loading
});

const mapDispatchToProps = dispatch => ({
    getPermissions: () => dispatch(startGettingPermissions())
});

export default connect(mapStateToProps, mapDispatchToProps)(PermissionList);
