package com.unitri.lucas.elasticloadbalancer.domain;

public interface Metrics {

    void calculateArrivalRate();
    void calculateServiceCharge();
    void calculateAverageTimePerRequest();
}
