package com.leito.talentresourceplanning.response.util;

import com.leito.talentresourceplanning.entity.BaseEntity;

import java.time.LocalDate;

public class BaseDetailResponse extends BaseResponse {

    private LocalDate createdAt;

    private LocalDate modifiedAt;

    private LocalDate trashedAt;

    private LocalDate removedAt;

    public BaseDetailResponse(BaseEntity item) {
        super(item);
        setCreatedAt(item.getCreatedAt());
        setModifiedAt(item.getModifiedAt());
        setTrashedAt(item.getTrashedAt());
        setRemovedAt(item.getRemovedAt());
        setLifeState(item.getLifeState(), item.getLifeStateDescription());
    }
}
