package com.unitri.lucas.elasticloadbalancer.service;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.util.math.ArrivalRate;
import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import com.unitri.lucas.elasticloadbalancer.util.math.RequestsAverage;
import com.unitri.lucas.elasticloadbalancer.util.math.ServiceRate;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.ArrivalRepresentation;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.RequestsRepresentation;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.ServiceRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

public class MetricsService {

    @Autowired
    private RepositoryRequest repositoryRequest;

    public ArrivalRepresentation getArrivalRate() {
//        Timestamp minTime = this.repositoryRequest.findMinTime();
//        Timestamp maxTime = this.repositoryRequest.findMaxTime();
//        long ammountOfRequests = this.repositoryRequest.quantityOfRequestsThatArrived();
//        ArrivalRate arrivalRate = new ArrivalRate(ammountOfRequests, minTime, maxTime);
//        return arrivalRate.calculateArrivalRate();
        return null;
    }

    public ArrivalRepresentation getArrivalRate(Timestamp start, Timestamp end) {
//        long ammountOfRequests = this.repositoryRequest.quantityOfRequestsThatArrivedBetweenPeriod(start, end);
//        ArrivalRate arrivalRate = new ArrivalRate(ammountOfRequests, start, end);
//        return arrivalRate.calculateArrivalRate();
        return null;
    }

    public ServiceRepresentation getServiceRate(){
//        Timestamp minTime = this.repositoryRequest.findMinTime();
//        Timestamp maxTime = this.repositoryRequest.findMaxTime();
//        long ammountOfRequests = this.repositoryRequest.quantityOfRequestDone();
//        ServiceRate serviceRate = new ServiceRate(ammountOfRequests, minTime, maxTime);
//        return serviceRate.calculateServiceRate();
        return null;
    }

    public ServiceRepresentation getServiceRate(Timestamp start, Timestamp end){
//        long ammountOfRequests = this.repositoryRequest.quantityOfRequestDoneBetweenPeriod(start, end);
//        ServiceRate serviceRate = new ServiceRate(ammountOfRequests, start, end);
//        return serviceRate.calculateServiceRate();
        return null;
    }

    public RequestsRepresentation getRequestsAverage(){
//        Timestamp minTime = this.repositoryRequest.findMinTime();
//        Timestamp maxTime = this.repositoryRequest.findMaxTime();
//        List<ProxyRequest> proxyRequests = this.repositoryRequest.findAll();
//        RequestsAverage requestsAverage = new RequestsAverage(proxyRequests, minTime, maxTime);
//        return requestsAverage.calculateRequestAverage();
        return null;
    }

    public RequestsRepresentation getRequestsAverage(Timestamp start, Timestamp end){
//        List<ProxyRequest> proxyRequests = this.repositoryRequest.findAllByTimeBetween(start, end);
//        RequestsAverage requestsAverage = new RequestsAverage(proxyRequests, start, end);
//        return requestsAverage.calculateRequestAverage();
        return null;
    }

}
