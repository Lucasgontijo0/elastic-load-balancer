package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.util.math.representation.ArrivalRepresentation;

import java.sql.Timestamp;

public class ArrivalRate {

    private long requestAmmount;
    private Timestamp startDate;
    private Timestamp endDate;

    public ArrivalRate(long requestAmmount, Timestamp startDate, Timestamp endDate) {
        this.requestAmmount = requestAmmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ArrivalRepresentation calculateArrivalRate() {

        Long duration = endDate.getTime() - startDate.getTime();

        double rate = requestAmmount / duration;

        return new ArrivalRepresentation(startDate, endDate, duration, requestAmmount, rate);
    }
}
