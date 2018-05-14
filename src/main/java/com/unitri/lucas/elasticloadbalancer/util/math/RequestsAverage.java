package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.RequestsRepresentation;

import java.math.BigDecimal;
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

        long requestAmmount = this.proxyRequests.size();
        Double diffSum = 0.0;

        for (ProxyRequest proxyRequest : this.proxyRequests) {
            diffSum += Math.abs(proxyRequest.getStartTime().getTime() - proxyRequest.getEndTime().getTime());
        }

        Double requestAverage = diffSum / requestAmmount;

        return new RequestsRepresentation(startDate, endDate, requestAmmount, requestAverage);
    }
}
