package com.leito.talentresourceplanning.entity;

/**
 * DON'T CHANGE THE ORDER!! In DB 0 (REGISTERED), 1 (CREATED), etc
 * If there is a need of creating some more, add at the end, but don't change the order
 */
public enum LifeState {
    REGISTERED,
    CREATED,
    ACTIVATED,
    SUSPENDED,
    BLOCKED,
    TRASHED,
    REMOVED
}
