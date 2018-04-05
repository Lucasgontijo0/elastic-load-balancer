package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.RequestsRepresentation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

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

        long requestAmmount = this.proxyRequests.size() / 2;
        long diffSum = 0L;

        Map<UUID, List<ProxyRequest>> requestMap =
                proxyRequests.stream().collect(
                        Collectors.groupingBy(ProxyRequest::getRequestId));

        for (List<ProxyRequest> requests: requestMap.values()) {
            diffSum += Math.abs(requests.get(0).getTime().getTime() - requests.get(1).getTime().getTime());
        }

        BigDecimal ammount = new BigDecimal(requestAmmount);
        BigDecimal diff = new BigDecimal(diffSum);
        BigDecimal requestAverage = diff.divide(ammount, 9, BigDecimal.ROUND_HALF_EVEN);


        return new RequestsRepresentation(startDate, endDate, requestAmmount, requestAverage);
    }
}
