package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {
//    @JsonIgnore
//    private List<HistoryTrack> historyTracks = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public void setLifeState(LifeState lifeState, String lifeStateDescription) {
        setLifeState(lifeState);
        setLifeStateDescription(lifeStateDescription);
    }
}
