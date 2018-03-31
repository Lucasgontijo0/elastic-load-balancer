package com.unitri.lucas.elasticloadbalancer.repository.impl;

import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryRequestImp implements RepositoryRequest {

    private List<ProxyRequest> requestPool;

    public RepositoryRequestImp() {
        this.requestPool = new ArrayList<>();
    }

    @Override
    public void addRequest(ProxyRequest request) {
        System.out.println(request);
        this.requestPool.add(request);
    }

    @Override
    public List<ProxyRequest> getAllRequests() {
        return this.requestPool;
    }

    @Override
    public List<ProxyRequest> getRequestByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        return searchRequestByDate(startDate, endDate);
    }

    private List<ProxyRequest> searchRequestByDate(LocalDateTime startDate, LocalDateTime endDate){

        List<ProxyRequest> requestBetweenDates = new ArrayList<>();

        this.requestPool.forEach( request -> {
                if (isBetweenDates(request, startDate, endDate)){
                    requestBetweenDates.add(request);
                }
            }
        );

        return requestBetweenDates;
    }

    private boolean isBetweenDates(ProxyRequest request, LocalDateTime start, LocalDateTime end){

        LocalDateTime requestTime = request.getTime();
        if (requestTime.isAfter(start) && requestTime.isBefore(end)){
            return true;
        }
        return false;
    }

}
