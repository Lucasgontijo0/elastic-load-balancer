package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.RequestsRepresentation;

import java.sql.Timestamp;
import java.util.List;

public class RequestsAverage {

    private List<ProxyRequest> proxyRequests;
    private Timestamp startDate;
    private Timestamp endDate;

    public RequestsAverage(List<ProxyRequest> proxyRequests, Timestamp startDate, Timestamp endDate) {
        this.proxyRequests = proxyRequests;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RequestsRepresentation calculateRequestAverage() {
        return null;
    }
}
