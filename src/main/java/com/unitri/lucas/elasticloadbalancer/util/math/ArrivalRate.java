package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.util.math.representation.ArrivalRepresentation;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ArrivalRate {

    private long requestAmmount;
    private Timestamp startDate;
    private Timestamp endDate;

    public ArrivalRate(long requestAmmount, Timestamp startDate, Timestamp endDate) {
        this.requestAmmount = requestAmmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ArrivalRepresentation calculateArrivalRate() {

        long duration = this.endDate.getTime() - this.startDate.getTime();

        BigDecimal ammount = new BigDecimal(this.requestAmmount);

        BigDecimal durationDivide = new BigDecimal(duration);

        BigDecimal rate = ammount.divide(durationDivide, 9, BigDecimal.ROUND_HALF_EVEN);

        return new ArrivalRepresentation(startDate, endDate, duration, requestAmmount, rate);
    }
}
