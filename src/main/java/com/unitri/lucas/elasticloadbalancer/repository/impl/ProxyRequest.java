package com.unitri.lucas.elasticloadbalancer.repository.impl;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProxyRequest {

    private UUID uuid;
    private LocalDateTime time;

    public ProxyRequest(UUID uuid, LocalDateTime time) {
        this.uuid = uuid;
        this.time = time;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ProxyRequest{" +
                "uuid=" + uuid +
                ", time=" + time +
                '}';
    }
}
