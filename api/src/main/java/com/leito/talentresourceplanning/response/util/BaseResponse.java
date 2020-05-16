package com.leito.talentresourceplanning.response.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
