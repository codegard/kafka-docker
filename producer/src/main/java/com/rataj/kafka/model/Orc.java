package com.rataj.kafka.model;

import java.util.UUID;

public final class Orc {

    private final UUID id;
    private final String nickname;

    public Orc(String nickname) {
        this.id = UUID.randomUUID();
        this.nickname = nickname;
    }

    public UUID id() {
        return id;
    }

    public String nickname() {
        return nickname;
    }

}
