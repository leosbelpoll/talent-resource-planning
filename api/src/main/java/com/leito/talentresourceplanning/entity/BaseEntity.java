package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {
//    @JsonIgnore
//    private List<HistoryTrack> historyTracks = new ArrayList<>();

    @JsonIgnore
    private Date createdAt;

    @JsonIgnore
    private Date modifiedAt;

    @JsonIgnore
    private Date trashedAt;

    @JsonIgnore
    private Date removedAt;

    @Setter(AccessLevel.PRIVATE)
    private LifeState lifeState;

    @Setter(AccessLevel.PRIVATE)
    private String lifeStateDescription;

    public void setAllDatesAt(BaseEntity entity) {
        setCreatedAt(entity.getCreatedAt());
        setModifiedAt(entity.getModifiedAt());
        setTrashedAt(entity.getTrashedAt());
        setRemovedAt(entity.getRemovedAt());
    }

    public void setLifeState(LifeState lifeState, String lifeStateDescription) {
        setLifeState(lifeState);
        setLifeStateDescription(lifeStateDescription);
    }
}
