package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.util.math.representation.ServiceRepresentation;

import java.sql.Timestamp;

public class ServiceRate {

    private long requestAmmount;
    private Timestamp startDate;
    private Timestamp endDate;

    public ServiceRate(long requestAmmount, Timestamp startDate, Timestamp endDate) {
        this.requestAmmount = requestAmmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ServiceRepresentation calculateServiceRate(){

        Long duration = endDate.getTime() - startDate.getTime();

        double rate = this.requestAmmount / duration;

        return new ServiceRepresentation(startDate, endDate, duration, this.requestAmmount, rate);

    }
}
