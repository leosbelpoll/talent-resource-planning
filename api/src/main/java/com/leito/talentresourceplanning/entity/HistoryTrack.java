package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Setter
@Getter
public class HistoryTrack {
    @JsonIgnore
    private BaseEntity entity;

    @JsonIgnore
    private String description;

    @JsonIgnore
    private String createdAt;
}
