package com.unitri.lucas.elasticloadbalancer.util.math.representation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class ArrivalRepresentation {

    private Timestamp startDate;
    private Timestamp endDate;
    private long duration;
    private Long ammount;
    private BigDecimal arrivalRate;

    public ArrivalRepresentation(Timestamp startDate, Timestamp endDate, long duration, Long ammount, BigDecimal arrivalRate) {
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
        ArrivalRepresentation that = (ArrivalRepresentation) o;
        return duration == that.duration &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(ammount, that.ammount) &&
                Objects.equals(arrivalRate, that.arrivalRate);
    }

    @Override
    public String toString() {
        return "ArrivalRepresentation{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", duration=" + duration +
                ", ammount=" + ammount +
                ", arrivalRate=" + arrivalRate +
                '}';
    }
}
