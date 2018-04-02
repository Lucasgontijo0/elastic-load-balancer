package com.unitri.lucas.elasticloadbalancer.service;

import com.unitri.lucas.elasticloadbalancer.domain.Rate;
import com.unitri.lucas.elasticloadbalancer.domain.average.representation.Arrival;
import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MetricsService {

    @Autowired
    RepositoryRequest repositoryRequest;

    @Autowired
    Rate rate;

    public Arrival getArrivalRate() {
//        long ammountRequests = this.repositoryRequest.getAmmountRequests();
//        LocalDateTime startDate = this.repositoryRequest.getMinDate();
//        LocalDateTime endDate = this.repositoryRequest.getMaxDate();
//        return rate.calculateArrivalRate(ammountRequests, startDate, endDate);
        return null;
    }

    public Arrival getArrivalRateInRange(LocalDateTime startTime, LocalDateTime endTime) {
//        long ammountRequest = this.repositoryRequest.getAmmountRequestByPeriod(startTime, endTime);
//        return rate.calculateArrivalRate(ammountRequest, startTime, endTime);
        return null;
    }

    public void getServiceCharge() {

    }

    public void getServiceChargeInRange(LocalDateTime startTime, LocalDateTime endTime) {

    }

    public void getAverageTimePerRequest() {

    }

    public void getAverageTimePerRequestInRange(LocalDateTime startTime, LocalDateTime endTime) {

    }
}
