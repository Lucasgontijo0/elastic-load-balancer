package com.unitri.lucas.elasticloadbalancer.domain.average.representation;

import java.time.Duration;
import java.time.LocalDateTime;

public class Arrival {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Duration duration;
    private Long ammount;
    private Double arrivalRate;

    public Arrival(LocalDateTime startDate, LocalDateTime endDate, Duration duration, Long ammount, Double arrivalRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.ammount = ammount;
        this.arrivalRate = arrivalRate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public Long getAmmount() {
        return ammount;
    }

    public Double getArrivalRate() {
        return arrivalRate;
    }
}
