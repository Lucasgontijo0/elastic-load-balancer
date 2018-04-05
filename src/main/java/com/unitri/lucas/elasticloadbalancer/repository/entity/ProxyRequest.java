package com.unitri.lucas.elasticloadbalancer.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class ProxyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID requestId;
    private Timestamp time;

    public ProxyRequest(UUID uuid, Timestamp time) {
        this.requestId = uuid;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public Timestamp getTime() {
        return time;
    }

}
