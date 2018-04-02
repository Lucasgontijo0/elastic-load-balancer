package com.unitri.lucas.elasticloadbalancer.service;

import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import com.unitri.lucas.elasticloadbalancer.repository.model.ProxyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestService {

    @Autowired
    private RepositoryRequest repositoryRequest;

    public void saveRequestInfo(ProxyRequest proxyRequest){
        this.repositoryRequest.save(proxyRequest);
    }

}
