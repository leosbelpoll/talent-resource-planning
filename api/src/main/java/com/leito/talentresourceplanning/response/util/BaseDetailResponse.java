package com.leito.talentresourceplanning.response.util;

import com.leito.talentresourceplanning.entity.BaseEntity;

import java.util.Date;

public class BaseDetailResponse extends BaseResponse {

    private Date createdAt;

    private Date modifiedAt;

    private Date trashedAt;

    private Date removedAt;

    public BaseDetailResponse(BaseEntity item) {
        setId(item.getId());
        setCreatedAt(item.getCreatedAt());
        setModifiedAt(item.getModifiedAt());
        setTrashedAt(item.getTrashedAt());
        setRemovedAt(item.getRemovedAt());
        setLifeState(item.getLifeState(), item.getLifeStateDescription());
    }
}
