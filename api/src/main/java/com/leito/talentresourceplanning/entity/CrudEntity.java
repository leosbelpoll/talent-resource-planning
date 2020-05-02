package com.leito.talentresourceplanning.entity;

import com.leito.talentresourceplanning.request.util.BaseCreateRequest;

public abstract class CrudEntity extends BaseEntity {
    public abstract void updateByCreateRequest(BaseCreateRequest request);
}
