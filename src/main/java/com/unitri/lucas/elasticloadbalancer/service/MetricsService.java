package com.unitri.lucas.elasticloadbalancer.service.metrics;

import com.unitri.lucas.elasticloadbalancer.domain.ArrivalRate;
import com.unitri.lucas.elasticloadbalancer.domain.RequestsRate;
import com.unitri.lucas.elasticloadbalancer.domain.ServiceRate;
import com.unitri.lucas.elasticloadbalancer.service.metrics.representation.Arrival;
import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    @Autowired
    private RepositoryRequest repositoryRequest;

    @Autowired
    private ArrivalRate arrivalRate;

    @Autowired
    private RequestsRate requestsRate;

    @Autowired
    private ServiceRate serviceRate;

    public Arrival gerArrivalRate() {

    }
}
