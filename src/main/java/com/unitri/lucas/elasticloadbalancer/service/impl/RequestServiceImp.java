package com.unitri.lucas.elasticloadbalancer.service.impl;

import com.unitri.lucas.elasticloadbalancer.repository.impl.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import com.unitri.lucas.elasticloadbalancer.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestServiceImp implements RequestService{

    @Autowired
    private RepositoryRequest repositoryRequest;

    public void saveRequestInfo(ProxyRequest proxyRequest){
        this.repositoryRequest.addRequest(proxyRequest);
    }

    @Override
    public List<ProxyRequest> getAllRequests() {
        return this.repositoryRequest.getAllRequests();
    }

    @Override
    public List<ProxyRequest> getRequestsBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return this.repositoryRequest.getRequestByPeriod(startDate, endDate);
    }

}
