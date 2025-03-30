package com.shopping.common.enums;

public enum DefaultUserStatus {
    ACTIVE(1L),
    INACTIVE(2L);

    private final Long id;
    DefaultUserStatus(Long id) { this.id = id; }
    public Long getId() { return id; }
}

