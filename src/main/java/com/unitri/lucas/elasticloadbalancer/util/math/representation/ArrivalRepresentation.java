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

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }

    public Double getArrivalRate() {
        return arrivalRate;
    }

    public void setArrivalRate(Double arrivalRate) {
        this.arrivalRate = arrivalRate;
    }
}
