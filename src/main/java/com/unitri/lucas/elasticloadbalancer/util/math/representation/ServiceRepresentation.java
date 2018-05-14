package com.unitri.lucas.elasticloadbalancer.util.math.representation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class ServiceRepresentation {

    private Timestamp startDate;
    private Timestamp endDate;
    private long duration;
    private Long ammount;
    private Double serviceRate;

    public ServiceRepresentation(Timestamp startDate, Timestamp endDate, long duration, Long ammount, Double serviceRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.ammount = ammount;
        this.serviceRate = serviceRate;
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

    public Double getServiceRate() {
        return serviceRate;
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
                Objects.equals(serviceRate, that.serviceRate);
    }

    @Override
    public String toString() {
        return "ServiceRepresentation{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", duration=" + duration +
                ", ammount=" + ammount +
                ", serviceRate=" + serviceRate +
                '}';
    }
}
