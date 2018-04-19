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
    private String status;
    private Timestamp startTime;
    private Timestamp endTime;
    private long serviceTime;

    public ProxyRequest(UUID requestId, String status, Timestamp startTime, Timestamp endTime, long serviceTime) {
        this.requestId = requestId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serviceTime = serviceTime;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public long getServiceTime() {
        return serviceTime;
    }
}
