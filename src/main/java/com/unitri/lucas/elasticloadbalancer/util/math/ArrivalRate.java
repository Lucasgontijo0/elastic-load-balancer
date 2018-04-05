package com.unitri.lucas.elasticloadbalancer.domain;

import com.unitri.lucas.elasticloadbalancer.service.representation.ArrivalRepresentation;

import java.sql.Timestamp;

public class ArrivalRate {

    /*
     * Calcula a taxa de chegada no proxy, independente se foram atendidas ou não.
     */

    private long requestAmmount;
    private Timestamp startDate;
    private Timestamp endDate;

    public ArrivalRate(long requestAmmount, Timestamp startDate, Timestamp endDate) {
        this.requestAmmount = requestAmmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ArrivalRepresentation calculateArrivalRate() {

        if (requestAmmount <= 0) {
            throw new RuntimeException("ProxyDecorator request must have values to calculate.");
        }

        Long duration = endDate.getTime() - startDate.getTime();

        double rate = requestAmmount / duration;

        return new ArrivalRepresentation(startDate, endDate, duration, requestAmmount, rate);
    }
}
