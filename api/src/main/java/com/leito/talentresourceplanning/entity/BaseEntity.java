package com.leito.talentresourceplanning.entity;

import com.leito.talentresourceplanning.request.util.BaseCreateRequest;
import com.leito.talentresourceplanning.util.BaseData;
import com.leito.talentresourceplanning.util.Messages;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public abstract class BaseEntity extends BaseData {
//    @JsonIgnore
//    private List<HistoryTrack> historyTracks = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static BaseEntity getByCreateRequest(BaseCreateRequest baseCreateRequest){
        throw new IllegalStateException(Messages.UTILITY_CLASS);
    }
}
