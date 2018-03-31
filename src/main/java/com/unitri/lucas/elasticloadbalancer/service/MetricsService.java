package com.unitri.lucas.elasticloadbalancer.service;

import java.time.LocalDateTime;

public interface MetricsService {

    void getArrivalRate();
    void getArrivalRateInRange(LocalDateTime startTime, LocalDateTime endTime);

    void getServiceCharge();
    void getServiceChargeInRange(LocalDateTime startTime, LocalDateTime endTime);

    void getAverageTimePerRequest();
    void getAverageTimePerRequestInRange(LocalDateTime startTime, LocalDateTime endTime);
}
