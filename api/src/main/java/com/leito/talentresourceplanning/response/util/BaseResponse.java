package com.leito.talentresourceplanning.response.util;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.entity.LifeState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class BaseResponse {
    private Long id;

    private LocalDate createdAt;

    private LifeState lifeState;

    private String lifeStateDescription;

    public void updateByEntity(BaseEntity item) {
        setId(item.getId());
        setCreatedAt(item.getCreatedAt());
        setLifeState(item.getLifeState());
        setLifeStateDescription(item.getLifeStateDescription());
    }
}
