package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.ArrivalRepresentation;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.ServiceRepresentation;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ServiceRateTest {

    @Test
    public void calculateServiceRate() {

        long requestAmmount = 100;
        Timestamp startDate = Timestamp.valueOf(LocalDateTime.of(2018, 1, 1, 1, 0, 0, 0));
        Timestamp endDate = Timestamp.valueOf(LocalDateTime.of(2018, 1, 1, 2, 0, 0, 0));

        ServiceRate serviceRate = new ServiceRate(requestAmmount, startDate, endDate);

        ServiceRepresentation result = serviceRate.calculateServiceRate();
        ServiceRepresentation expected = new ServiceRepresentation(
                startDate, endDate, 3600000, requestAmmount, new BigDecimal(0.000027778).setScale(9, BigDecimal.ROUND_HALF_EVEN)
        );

        assertEquals(expected.equals(result), true);
    }

}