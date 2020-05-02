package com.leito.talentresourceplanning.response.util;

import com.leito.talentresourceplanning.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class BaseDetailResponse extends BaseResponse {

    private LocalDate modifiedAt;

    private LocalDate trashedAt;

    private LocalDate removedAt;

    public void updateByEntity(BaseEntity item) {
        super.updateByEntity(item);
        setModifiedAt(item.getModifiedAt());
        setTrashedAt(item.getTrashedAt());
        setRemovedAt(item.getRemovedAt());
    }

}
