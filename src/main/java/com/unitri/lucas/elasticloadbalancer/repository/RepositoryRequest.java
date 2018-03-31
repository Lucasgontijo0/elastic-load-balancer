package com.unitri.lucas.elasticloadbalancer.repository;

import com.unitri.lucas.elasticloadbalancer.repository.impl.ProxyRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositoryRequest {

    void addRequest(ProxyRequest request);
    List<ProxyRequest> getAllRequests();
    List<ProxyRequest> getRequestByPeriod(LocalDateTime startDate, LocalDateTime endDate);
}
