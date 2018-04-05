package com.unitri.lucas.elasticloadbalancer.util.math.representation;

import java.sql.Timestamp;

public class ArrivalRepresentation {

    private Timestamp startDate;
    private Timestamp endDate;
    private long duration;
    private Long ammount;
    private Double arrivalRate;

    public ArrivalRepresentation(Timestamp startDate, Timestamp endDate, long duration, Long ammount, Double arrivalRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.ammount = ammount;
        this.arrivalRate = arrivalRate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public long getDuration() {
        return duration;
    }

    public Long getAmmount() {
        return ammount;
    }

    public Double getArrivalRate() {
        return arrivalRate;
    }
}
