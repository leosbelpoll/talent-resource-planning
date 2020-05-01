package com.leito.talentresourceplanning.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leito.talentresourceplanning.entity.LifeState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Setter
@Getter
public class BaseData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdAt;

    @JsonIgnore
    private LocalDate modifiedAt;

    @JsonIgnore
    private LocalDate trashedAt;

    @JsonIgnore
    private LocalDate removedAt;

    @Setter(AccessLevel.PRIVATE)
    private LifeState lifeState;

    @Setter(AccessLevel.PRIVATE)
    private String lifeStateDescription;

    public void setLifeState(LifeState lifeState) {
        this.lifeState = lifeState;
        setLifeStateDescription(lifeState.toString());
    }

    public void setLifeState(LifeState lifeState, String lifeStateDescription) {
        setLifeState(lifeState);
        setLifeStateDescription(lifeStateDescription);
    }
}
