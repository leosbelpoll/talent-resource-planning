package com.leito.talentresourceplanning.response.util;

import com.leito.talentresourceplanning.entity.BaseEntity;

public class BaseResponse extends BaseEntity {
    public BaseResponse(BaseEntity item) {
        setId(item.getId());
    }
}
