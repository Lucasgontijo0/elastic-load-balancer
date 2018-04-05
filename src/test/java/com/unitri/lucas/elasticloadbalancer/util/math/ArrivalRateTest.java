package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.util.math.representation.ArrivalRepresentation;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ArrivalRateTest {

    @Test
    public void calculateArrivalRate() {

        long requestAmmount = 100;
        Timestamp startDate = Timestamp.valueOf(LocalDateTime.of(2018, 1, 1, 1, 0, 0, 0));
        Timestamp endDate = Timestamp.valueOf(LocalDateTime.of(2018, 1, 1, 2, 0, 0, 0));

        ArrivalRate arrivalRate = new ArrivalRate(requestAmmount, startDate, endDate);

        ArrivalRepresentation result = arrivalRate.calculateArrivalRate();
        ArrivalRepresentation expected = new ArrivalRepresentation(
                startDate, endDate, 3600000, requestAmmount, new BigDecimal(0.000027778).setScale(9, BigDecimal.ROUND_HALF_EVEN));

        assertEquals(expected.equals(result), true);
    }
}