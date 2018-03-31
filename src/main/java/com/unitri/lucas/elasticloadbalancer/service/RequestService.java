package com.unitri.lucas.elasticloadbalancer.service;

import com.unitri.lucas.elasticloadbalancer.repository.impl.ProxyRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestService {

    void saveRequestInfo(ProxyRequest proxyRequest);
    List<ProxyRequest> getAllRequests();
    List<ProxyRequest> getRequestsBetween(LocalDateTime startDate, LocalDateTime endDate);
}
