package com.unitri.lucas.elasticloadbalancer.domain.average;

import com.unitri.lucas.elasticloadbalancer.domain.average.representation.Arrival;
import com.unitri.lucas.elasticloadbalancer.repository.model.ProxyRequest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ArrivalRate {

    public Arrival calculateArrivalRate(long requestAmmount, LocalDateTime startDate, LocalDateTime endDate) {

        if (requestAmmount <= 0) {
            throw new RuntimeException("ProxyDecorator request must have values to calculate.");
        }

        return arrivalRate(requestAmmount, startDate, endDate);
    }

    private Arrival arrivalRate(long requestAmmount, LocalDateTime startDate, LocalDateTime endDate) {

        Duration difference = Duration.between(startDate, endDate);
        Long duration = difference.toMillis();

        double rate = requestAmmount / duration;

        return new Arrival(startDate, endDate, difference, requestAmmount, rate);
    }
}
