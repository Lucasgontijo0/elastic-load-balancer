package com.unitri.lucas.elasticloadbalancer.domain;

import com.unitri.lucas.elasticloadbalancer.domain.average.ArrivalRate;
import com.unitri.lucas.elasticloadbalancer.domain.average.representation.Arrival;
import com.unitri.lucas.elasticloadbalancer.domain.average.representation.Requests;
import com.unitri.lucas.elasticloadbalancer.domain.average.representation.Service;
import com.unitri.lucas.elasticloadbalancer.repository.model.ProxyRequest;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class Rate{

    public Arrival calculateArrivalRate(long ammountRequest, LocalDateTime startDate, LocalDateTime endDate) {
        ArrivalRate arrivalRate = new ArrivalRate();
        return arrivalRate.calculateArrivalRate(ammountRequest, startDate, endDate);
    }

    public Service calculateServiceCharge() {
        //TODO: UNINPLEMENTED METHOD
        return null;
    }

    public Requests calculateAverageTimePerRequest(List<ProxyRequest> proxyRequestList) {
        //TODO: UNINPLEMENTED METHOD
        return null;
    }
}
