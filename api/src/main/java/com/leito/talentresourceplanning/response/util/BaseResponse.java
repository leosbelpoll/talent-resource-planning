package com.leito.talentresourceplanning.response.util;

import com.leito.talentresourceplanning.util.BaseData;

public class BaseResponse extends BaseData {
    public BaseResponse(BaseData item) {
        setId(item.getId());
    }
}
