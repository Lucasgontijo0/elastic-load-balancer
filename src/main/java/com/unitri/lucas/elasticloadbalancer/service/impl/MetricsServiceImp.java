package com.unitri.lucas.elasticloadbalancer.service.impl;

import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import com.unitri.lucas.elasticloadbalancer.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MetricsServiceImp implements MetricsService {

    @Autowired
    RepositoryRequest repositoryRequest;

    @Override
    public void getArrivalRate() {

    }

    @Override
    public void getArrivalRateInRange(LocalDateTime startTime, LocalDateTime endTime) {

    }

    @Override
    public void getServiceCharge() {

    }

    @Override
    public void getServiceChargeInRange(LocalDateTime startTime, LocalDateTime endTime) {

    }

    @Override
    public void getAverageTimePerRequest() {

    }

    @Override
    public void getAverageTimePerRequestInRange(LocalDateTime startTime, LocalDateTime endTime) {

    }
}
