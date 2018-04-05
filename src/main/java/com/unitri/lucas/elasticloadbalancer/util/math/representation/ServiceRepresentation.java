package com.unitri.lucas.elasticloadbalancer.util.math.representation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class ServiceRepresentation {

    private Timestamp startDate;
    private Timestamp endDate;
    private long duration;
    private Long ammount;
    private BigDecimal arrivalRate;

    public ServiceRepresentation(Timestamp startDate, Timestamp endDate, long duration, Long ammount, BigDecimal arrivalRate) {
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

    public BigDecimal getArrivalRate() {
        return arrivalRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceRepresentation that = (ServiceRepresentation) o;
        return duration == that.duration &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(ammount, that.ammount) &&
                Objects.equals(arrivalRate, that.arrivalRate);
    }
}
