package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {
//    @JsonIgnore
//    private List<HistoryTrack> historyTracks = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
